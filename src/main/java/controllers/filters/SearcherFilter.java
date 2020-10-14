/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.filters;

import com.google.gson.Gson;
import models.entities.Song;
import models.repositories.SongRepositoryJdbc;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/searcher", filterName = "searcher")
public class SearcherFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        System.out.println(req.getMethod());

        if (req.getMethod().equals("GET")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        System.out.println(req.getParameterMap());

        String words = servletRequest.getParameter("searchField");
        DataSource dataSource = (DataSource) servletRequest.getServletContext().getAttribute("datasource");
        SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);
        List<Song> songs = songRepositoryJdbc.searchByWords(words==null?"":words);
        System.out.println(songs);
        String json = new Gson().toJson(songs);
        System.out.println(json);
        servletResponse.setContentType("application/json");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getOutputStream().print(json);


    }
}
