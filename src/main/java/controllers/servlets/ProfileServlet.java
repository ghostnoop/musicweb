/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

import mapper.DataMapper;
import models.entities.Artist;
import models.entities.Genre;
import models.entities.Song;
import models.entities.User;
import models.repositories.SongRepositoryJdbc;
import models.repositories.orm.OrmRepositoryJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session != null && session.getAttribute("user") != null) {
            DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
            OrmRepositoryJdbc ormRepositoryJdbc = new OrmRepositoryJdbc(dataSource, new DataMapper());
            SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);

            boolean isArtist = req.getSession().getAttribute("isArtist") != null;

            if (isArtist) {
                Artist artist = (Artist) session.getAttribute("user");
                List<Song> songs = songRepositoryJdbc.getByArtistId(artist.getId());

                req.setAttribute("user", artist);
                req.setAttribute("songs", songs);
                req.setAttribute("isArtist", true);

            } else {
                User user = (User) session.getAttribute("user");
                List<Song> songs = songRepositoryJdbc.getFromLiked(user.getId());

                req.setAttribute("user", user);
                req.setAttribute("songs", songs);
            }

            List<Genre> genres = ormRepositoryJdbc.findAll(Genre.class);

            req.setAttribute("genres", genres);
            req.setAttribute("profile", true);

            req.getRequestDispatcher("/profile.ftl").forward(req, resp);
        } else
            resp.sendRedirect("/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
