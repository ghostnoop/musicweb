/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

import models.entities.Artist;
import models.repositories.ArtistRepositoryJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/artists")
public class ArtistsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        ArtistRepositoryJdbc artistRepositoryJdbc = new ArtistRepositoryJdbc(dataSource);

        List<Artist> artists = artistRepositoryJdbc.getAll();


        req.setAttribute("artists", artists);
        req.getRequestDispatcher("/artists.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
