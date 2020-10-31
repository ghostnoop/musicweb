/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

import models.entities.Album;
import models.repositories.AlbumRepositoryJdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/albums")
public class AlbumsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        AlbumRepositoryJdbc albumRepositoryJdbc = new AlbumRepositoryJdbc(dataSource);
        List<Album> albums = albumRepositoryJdbc.getAll();

        req.setAttribute("albums", albums);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/albums.ftl");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
