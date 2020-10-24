/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.filters;

import com.google.gson.Gson;
import models.entities.Song;
import models.repositories.SongRepositoryJdbc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/searchsong", filterName = "playerSong")
public class PlayerSongFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            int songId = Integer.parseInt(servletRequest.getParameter("id"));

            DataSource dataSource = (DataSource) servletRequest.getServletContext().getAttribute("datasource");
            SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);

            Song song = songRepositoryJdbc.getById(songId);

            String json = new Gson().toJson(song);
            System.out.println(json);
            servletResponse.setContentType("application/json; charset=UTF-8");
            servletResponse.setCharacterEncoding("UTF-8");
            PrintWriter out = servletResponse.getWriter();
            out.print(json);



        } catch (NumberFormatException ex) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
