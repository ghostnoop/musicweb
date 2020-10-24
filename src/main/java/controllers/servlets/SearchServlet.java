/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

import app.Utils;
import models.entities.Song;
import models.repositories.SongRepositoryJdbc;

import javax.rmi.CORBA.Util;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/searcher")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String words = req.getParameter("search");
        String filter = req.getParameter("filter");

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);

        List<Song> songs = songRepositoryJdbc.searchByWords(words==null?"":words, Utils.parseFilter(filter));

        req.setAttribute("searchField",words);
        req.setAttribute("songs",songs.isEmpty()?null:songs);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/searcher.ftl");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
