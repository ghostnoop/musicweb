/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

import models.entities.Album;
import models.entities.Artist;
import models.entities.Song;
import models.repositories.AlbumRepositoryJdbc;
import models.repositories.ArtistRepositoryJdbc;
import models.repositories.SongRepositoryJdbc;
import models.repositories.interfaces.ArtistRepository;
import models.repositories.interfaces.SongRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        SongRepository

//        SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc((Connection) req.getServletContext().getAttribute("connection"));
//        List<Song> songs = songRepositoryJdbc.getAll();
//
//        AlbumRepositoryJdbc albumRepositoryJdbc = new AlbumRepositoryJdbc((Connection) req.getServletContext().getAttribute("connection"));
//        List<Album> albums = albumRepositoryJdbc.getAll();
//
//        ArtistRepositoryJdbc artistRepositoryJdbc = new ArtistRepositoryJdbc((Connection) req.getServletContext().getAttribute("connection"));
//        List<Artist> artists = artistRepositoryJdbc.getAll();
//
//
//        System.out.println(songs);
//        req.setAttribute("songs", songs);
//        req.setAttribute("albums", albums);
//        req.setAttribute("artists", artists);
//
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main.ftl");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
