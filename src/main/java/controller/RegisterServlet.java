/**
 * @author Gilyazov Marat
 * 11-905
 */

package controller;

import models.entities.User;
import models.repositories.UserRepositoryJdbc;

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
        req.setAttribute("title", "Register - Music");



        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jsp/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Register - Music");
        UserRepositoryJdbc userRepositoryJdbc = (UserRepositoryJdbc) req.getServletContext().getAttribute("jdbc");

//        todo check with reg exp email
//        todo check email if exist
        String email = req.getParameter("user-email");

        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            req.setAttribute("error", true);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jsp/register.jsp");
            requestDispatcher.forward(req, resp);
        }


        boolean answ = userRepositoryJdbc.emailExist(email);
        if (answ) {
            req.setAttribute("error", true);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jsp/register.jsp");
            requestDispatcher.forward(req, resp);
        }

        User user = new User(
                req.getParameter("user-email"),
                req.getParameter("user-login"),
                req.getParameter("user-lastname"),
                "",
                req.getParameter("user-password"));
        boolean userSaved = userRepositoryJdbc.save(user);

        if (userSaved){
//todo save in session
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/index");


        }
        else {
            req.setAttribute("error", true);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jsp/register.jsp");
            requestDispatcher.forward(req, resp);
        }


    }
}
