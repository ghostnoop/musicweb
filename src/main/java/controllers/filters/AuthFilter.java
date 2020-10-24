/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.filters;

import models.entities.Artist;
import models.entities.User;
import models.repositories.ArtistRepositoryJdbc;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(urlPatterns = {"/login", "/register"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");


        UserRepositoryJdbc usersRepository = new UserRepositoryJdbc(dataSource);
        ArtistRepositoryJdbc artistRepositoryJdbc = new ArtistRepositoryJdbc(dataSource);

        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("user") != null) {
            resp.sendRedirect("/index");
        } else {
            String email = null;
            String password = null;
            boolean isArtist = false;

            Cookie[] cookies = req.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email")) email = cookie.getValue();
                if (cookie.getName().equals("password")) password = cookie.getValue();
                if (cookie.getName().equals("isArtist")) isArtist = cookie.getValue().equals("true");
            }
            if (email != null && password != null) {
                Object user = isArtist ? artistRepositoryJdbc.getByEmail(email) : usersRepository.getByEmail(email);
                if (user != null && password.equals(isArtist ? ((Artist) user).getPassword() : ((User) user).getPassword())) {
                    req.getSession().setAttribute("user", user);
                    if (isArtist)
                        req.getSession().setAttribute("isArtist", true);
                    resp.sendRedirect("/index");
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);



    }

    @Override
    public void destroy() {

    }
}
