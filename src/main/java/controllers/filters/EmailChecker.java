package controllers.filters;


import models.repositories.UserRepositoryJdbc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/emailexist", filterName = "emailChecker")
public class EmailChecker implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {


    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UserRepositoryJdbc userRepositoryJdbc = (UserRepositoryJdbc) servletRequest.getServletContext().getAttribute("jdbc");

        String email = servletRequest.getParameter("email");
        boolean answ = userRepositoryJdbc.emailExist(email);

        servletResponse.setContentType("application/json");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getOutputStream().print("{\"exist\": " + answ + "}");

    }

}
