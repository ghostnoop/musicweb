package controllers.filters;


import models.repositories.UserRepositoryJdbc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.sql.DataSource;
import java.io.IOException;

@WebFilter(urlPatterns = "/emailexist", filterName = "emailChecker")
public class EmailChecker implements Filter {

    public void init(FilterConfig filterConfig) {
    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException {
        DataSource dataSource = (DataSource) servletRequest.getServletContext().getAttribute("datasource");
        UserRepositoryJdbc usersRepository = new UserRepositoryJdbc(dataSource);

        String email = servletRequest.getParameter("email");
        boolean ans = usersRepository.emailExist(email);

        servletResponse.setContentType("application/json");
        servletResponse.setCharacterEncoding("UTF-8");

        servletResponse.getOutputStream().print("{\"exist\": " + ans + "}");

    }

}
