/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets.detail;

import models.entities.Artist;
import models.entities.Comment;
import models.entities.Song;
import models.entities.User;
import models.repositories.ArtistRepositoryJdbc;
import models.repositories.CommentRepositoryJdbc;
import models.repositories.LikedRepositoryJdbc;
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

@WebServlet(urlPatterns = "/detail/song")
public class DetailSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int songId = Integer.parseInt(req.getParameter("id"));
            DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

            SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);
            CommentRepositoryJdbc commentRepositoryJdbc = new CommentRepositoryJdbc(dataSource);
            LikedRepositoryJdbc likedRepositoryJdbc = new LikedRepositoryJdbc(dataSource);
            ArtistRepositoryJdbc artistRepositoryJdbc = new ArtistRepositoryJdbc(dataSource);


            Song song = songRepositoryJdbc.getById(songId);
            int countOfLikes = likedRepositoryJdbc.getCountOfLikesBySongId(songId);

            List<Comment> comments = commentRepositoryJdbc.getAllBySongId(songId);
            List<Artist> artists = artistRepositoryJdbc.getTopArtistByLiked();


            if (req.getSession().getAttribute("isArtist") == null) {
                User user = (User) req.getSession().getAttribute("user");

                if (user != null) {
                    req.setAttribute("user", user);
                    boolean liked = likedRepositoryJdbc.isUserLikedSong(user.getId(), songId);
                    req.setAttribute("liked", liked);
                }
            }

            req.setAttribute("song", song);
            req.setAttribute("likes", countOfLikes);
            req.setAttribute("comments", comments);
            req.setAttribute("topArtists", artists);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/details/musicpage.ftl");
            requestDispatcher.forward(req, resp);


        } catch (NumberFormatException exp) {
            resp.sendRedirect("/index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
