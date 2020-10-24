/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.filters;

import models.entities.Liked;
import models.entities.Song;
import models.entities.User;
import models.repositories.LikedRepositoryJdbc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(urlPatterns = "/like", filterName = "likedFilter")
public class LikedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        try {


            User user = (User) req.getSession().getAttribute("user");
            if (user == null) {
                resp.sendRedirect("/index");
                return;
            }

            DataSource dataSource = (DataSource) servletRequest.getServletContext().getAttribute("datasource");
            LikedRepositoryJdbc likedRepositoryJdbc = new LikedRepositoryJdbc(dataSource);

            int song_id = Integer.parseInt(servletRequest.getParameter("song_id"));
            boolean like = Boolean.parseBoolean(servletRequest.getParameter("like"));
            Liked liked = Liked.builder()
                    .user_id(user)
                    .song_id(Song.builder().id(song_id).build())
                    .build();

            if (like) {
                likedRepositoryJdbc.save(liked);
            } else {
                likedRepositoryJdbc.deleteLike(liked);
            }

        } catch (NumberFormatException | ClassCastException ex) {
            resp.sendRedirect("/404");
        }

    }
}
