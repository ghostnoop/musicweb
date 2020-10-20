/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets.detail;

import mapper.DataMapper;
import models.entities.Artist;
import models.entities.Genre;
import models.entities.Song;
import models.repositories.ArtistRepositoryJdbc;
import models.repositories.SongRepositoryJdbc;
import models.repositories.orm.OrmRepositoryJdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/detail/artist")
public class DetailArtistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        try {
            int artist_id = Integer.parseInt(req.getParameter("id"));

            ArtistRepositoryJdbc artistRepositoryJdbc = new ArtistRepositoryJdbc(dataSource);
            SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);
            OrmRepositoryJdbc ormRepositoryJdbc = new OrmRepositoryJdbc(dataSource, new DataMapper());

            Artist artist = artistRepositoryJdbc.getById(artist_id);
            List<Song> songs = songRepositoryJdbc.getByArtistId(artist_id);
            List<Genre> genres = ormRepositoryJdbc.findAll(Genre.class);

            req.setAttribute("artist", artist);
            req.setAttribute("songs", songs);
            req.setAttribute("genres", genres);

            boolean isArtist = req.getSession().getAttribute("isArtist") != null;
            req.setAttribute("isArtist", isArtist);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/details/artistpage.ftl");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.sendRedirect("/404");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
