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

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static app.Constants.regexEmail;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("title", "Register - Music");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/register.ftl");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Register - Music");

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        UserRepositoryJdbc usersRepository = new UserRepositoryJdbc(dataSource);
        ArtistRepositoryJdbc artistRepositoryJdbc = new ArtistRepositoryJdbc(dataSource);

        String email = req.getParameter("user-email");

        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            setError(req, resp,"your email not in email pattern");
        }

        boolean isArtist = req.getParameter("isArtist") != null;
        boolean saved = false;
        boolean ans = isArtist ? artistRepositoryJdbc.emailExist(email) : usersRepository.emailExist(email);

        if (ans) {
            setError(req, resp,"User is exist");
        }

        Object user = isArtist ? saveArtist(req) : saveUser(req);
        saved = isArtist ? artistRepositoryJdbc.save((Artist) user) : usersRepository.save((User) user);

        if (saved) {
            req.getSession().setAttribute("isArtist", isArtist);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/index");


        } else {
            setError(req, resp,"Some error");
        }


    }

    private Artist saveArtist(HttpServletRequest req) {
        return Artist.builder()
                .email(req.getParameter("user-email"))
                .name(req.getParameter("user-login"))
                .lastname(req.getParameter("user-lastname"))
                .password(Utils.hashingPassword(req.getParameter("user-password")))
                .build();
    }

    private User saveUser(HttpServletRequest req) {
        return User.builder()
                .email(req.getParameter("user-email"))
                .name(req.getParameter("user-login"))
                .lastname(req.getParameter("user-lastname"))
                .password(Utils.hashingPassword(req.getParameter("user-password")))
                .build();
    }

    private void setError(HttpServletRequest req, HttpServletResponse resp,String message) throws ServletException, IOException {
        req.setAttribute("error", message);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/register.ftl");
        requestDispatcher.forward(req, resp);
    }
}