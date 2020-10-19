

package controllers.filters;

import models.entities.Comment;
import models.entities.Song;
import models.entities.User;
import models.repositories.CommentRepositoryJdbc;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebFilter(urlPatterns = "/commentsave", filterName = "commentsave")
public class CommentSaverFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        try {
            User user = (User) req.getSession().getAttribute("user");
            int song_id = Integer.parseInt(req.getParameter("song_id"));
            String user_text = req.getParameter("user_text");


            DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
            CommentRepositoryJdbc commentRepositoryJdbc = new CommentRepositoryJdbc(dataSource);

            commentRepositoryJdbc.save(
                    Comment.builder()
                            .user_id(user)
                            .song_id(Song.builder().id(song_id).build())
                            .user_text(user_text).build());

            resp.sendRedirect("/detail/song?id="+song_id);

        } catch (Exception e) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

//        filterChain.doFilter(servletRequest, servletResponse);
    }
}
