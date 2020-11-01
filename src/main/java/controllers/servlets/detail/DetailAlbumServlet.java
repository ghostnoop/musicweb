/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets.detail;

import models.entities.Album;
import models.entities.Artist;
import models.entities.Song;
import models.repositories.AlbumRepositoryJdbc;
import models.repositories.ArtistRepositoryJdbc;
import models.repositories.SongRepositoryJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/detail/album")
public class DetailAlbumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int album_id = Integer.parseInt(req.getParameter("id"));

            DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
            SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);
            ArtistRepositoryJdbc artistRepositoryJdbc = new ArtistRepositoryJdbc(dataSource);
            AlbumRepositoryJdbc albumRepositoryJdbc = new AlbumRepositoryJdbc(dataSource);

            Album album = albumRepositoryJdbc.getById(album_id);
            List<Song> songs = songRepositoryJdbc.getByAlbumId(album_id);
            List<Artist> topArtists = artistRepositoryJdbc.getTopArtistByLiked();


            req.setAttribute("album", album);
            req.setAttribute("songs", songs);
            req.setAttribute("topArtists", topArtists);

            req.getRequestDispatcher("/details/albumpage.ftl").forward(req, resp);

        } catch (NumberFormatException except) {
            resp.sendRedirect("/index");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
