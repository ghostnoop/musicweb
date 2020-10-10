package filters;


import app.Constants;
import app.DataSourcePick;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

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
