/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

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

        UserRepositoryJdbc userRepositoryJdbc = (UserRepositoryJdbc) req.getServletContext().getAttribute("jdbc");
        ArtistRepositoryJdbc artistRepositoryJdbc = (ArtistRepositoryJdbc) req.getServletContext().getAttribute("jdbc");


        String email = req.getParameter("user-email");

        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            setError(req,resp);
        }

        boolean isArtist = req.getParameter("isArtist").equals("yes");
        boolean saved;
        boolean ans = isArtist ? artistRepositoryJdbc.emailExist(email) : userRepositoryJdbc.emailExist(email);

        if (ans) {
            setError(req,resp);
        }

        Object user = isArtist?saveArtist(req):saveUser(req);
        saved=isArtist?artistRepositoryJdbc.save((Artist) user):userRepositoryJdbc.save((User) user);

        if (saved) {
            req.getSession().setAttribute("isArtist",isArtist);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/index");


        } else {
            setError(req,resp);
        }


    }

    private Artist saveArtist(HttpServletRequest req) {
        return new Artist(
                req.getParameter("user-email"),
                req.getParameter("user-login"),
                req.getParameter("user-lastname"),
                "",
                req.getParameter("user-password"));
    }

    private User saveUser(HttpServletRequest req) {
        return new User(
                req.getParameter("user-email"),
                req.getParameter("user-login"),
                req.getParameter("user-lastname"),
                "",
                req.getParameter("user-password"));
    }

    private void setError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("error", true);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jsp/register.jsp");
        requestDispatcher.forward(req, resp);
    }
}
