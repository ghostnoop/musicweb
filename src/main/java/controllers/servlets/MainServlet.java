/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

import models.entities.Album;
import models.entities.Song;
import models.repositories.AlbumRepositoryJdbc;
import models.repositories.SongRepositoryJdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/index", ""})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);
        AlbumRepositoryJdbc albumRepositoryJdbc = new AlbumRepositoryJdbc(dataSource);

        List<Song> songs = songRepositoryJdbc.getAll();
        List<Album> albums = albumRepositoryJdbc.getAll();

        req.setAttribute("songs", songs);
        req.setAttribute("albums", albums);
        req.setAttribute("user", req.getSession().getAttribute("user"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main.ftl");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
