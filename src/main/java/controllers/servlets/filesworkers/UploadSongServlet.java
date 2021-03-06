/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets.filesworkers;

import app.Utils;
import models.entities.Artist;
import models.entities.Genre;
import models.entities.Song;
import models.repositories.SongRepositoryJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@MultipartConfig
@WebServlet(urlPatterns = "/uploadsong")
public class UploadSongServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        boolean isArtist = req.getSession().getAttribute("isArtist") != null;

        if (!isArtist) {
            resp.sendRedirect("/index");
            return;
        }


        String trackName = req.getParameter("track_name");
        int genreSelected = Integer.parseInt(req.getParameter("genre_selected")) + 1;

        String img_name = Utils.fileSaver(req.getPart("track_img"));
        String music_name = Utils.fileSaver(req.getPart("track"));

        Artist artist = (Artist) req.getSession().getAttribute("user");

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
        SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);

        Song song = Song.builder()
                .artist_id(Artist.builder()
                        .id(artist.getId()).build())
                .title(trackName)
                .music_url(music_name)
                .cover_img(img_name)
                .album_id(null)
                .genre_id(Genre.builder().id(genreSelected).build())
                .build();

        songRepositoryJdbc.save(song);

        resp.sendRedirect("/profile");
    }

}
