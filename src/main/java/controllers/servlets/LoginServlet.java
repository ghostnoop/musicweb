/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

import app.Utils;
import models.entities.Artist;
import models.entities.User;
import models.repositories.ArtistRepositoryJdbc;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("auth", true);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.ftl");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        UserRepositoryJdbc usersRepository = new UserRepositoryJdbc(dataSource);
        ArtistRepositoryJdbc artistRepositoryJdbc = new ArtistRepositoryJdbc(dataSource);

        String email = req.getParameter("user-login");
        String password = req.getParameter("user-password");
        boolean remember = req.getParameter("rememberme") != null;
        boolean isArtist = req.getParameter("is-artist") != null;

        password = Utils.hashingPassword(password);
        if (email != null && password != null) {
            Object user = isArtist ? artistRepositoryJdbc.getByEmail(email) : usersRepository.getByEmail(email);
            if (user == null) {
                setError(req, resp, "Does not exist");
                return;
            }
            String passwordVerify = isArtist ? ((Artist) user).getPassword() : ((User) user).getPassword();

            if (!password.equals(passwordVerify)) {
                setError(req, resp, "Password mismatch");
                return;
            }
            if (remember) {
                resp.addCookie(new Cookie("email", email));
                resp.addCookie(new Cookie("password", password));
                if (isArtist)
                    resp.addCookie(new Cookie("isArtist", "true"));
            }
            req.getSession().setAttribute("user", user);
            if (isArtist)
                req.getSession().setAttribute("isArtist", true);
            resp.sendRedirect("/index");
        } else {
            setError(req, resp, "Data mismatch");
            return;
        }
    }

    private void setError(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
        req.setAttribute("error", message);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.ftl");
        requestDispatcher.forward(req, resp);
    }

}

