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
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebFilter(urlPatterns = "/searchalbum", filterName = "playerAlbum")
public class PlayerAlbumFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            int albumId = Integer.parseInt(servletRequest.getParameter("id"));

            DataSource dataSource = (DataSource) servletRequest.getServletContext().getAttribute("datasource");
            SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);
            List<Song> songs=songRepositoryJdbc.getByAlbumId(albumId);

            String json = new Gson().toJson(songs);
            servletResponse.setContentType("application/json; charset=UTF-8");
            servletResponse.setCharacterEncoding("UTF-8");
            PrintWriter out = servletResponse.getWriter();
            out.print(json);



        } catch (NumberFormatException ex) {
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }
}
