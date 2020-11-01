/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.filters;

import app.Utils;
import com.google.gson.Gson;
import models.entities.Song;
import models.repositories.SongRepositoryJdbc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebFilter(urlPatterns = "/searcher", filterName = "searcher")
public class SearcherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if (req.getParameter("ajax") == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String words = servletRequest.getParameter("searchField");
        String filter = servletRequest.getParameter("filter");

        DataSource dataSource = (DataSource) servletRequest.getServletContext().getAttribute("datasource");
        SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);

        List<Song> songs = songRepositoryJdbc.searchByWords(words == null ? "" : words, Utils.parseFilter(filter));

        String json = new Gson().toJson(songs);
        servletResponse.setContentType("application/json; charset=UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = servletResponse.getWriter();
        out.print(json);
    }
}
