/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

import mapper.DataMapper;
import models.entities.Genre;
import models.entities.Song;
import models.repositories.SongRepositoryJdbc;
import models.repositories.orm.OrmRepositoryJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/genres")
public class GenresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String probablyId = req.getParameter("id");

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);
        OrmRepositoryJdbc ormRepositoryJdbc = new OrmRepositoryJdbc(dataSource, new DataMapper());

        List<Genre> genres = ormRepositoryJdbc.findAll(Genre.class);

        req.setAttribute("genres", genres);

        if (probablyId == null || probablyId.equals("")) {
            List<Song> songs = songRepositoryJdbc.getAll();
            req.setAttribute("songs", songs);
            req.setAttribute("name", "ALL");

            req.getRequestDispatcher("/genres.ftl").forward(req, resp);

        } else {
            int genreId = Integer.parseInt(probablyId);
            Genre genre = genres.stream().filter(i -> i.getId() == genreId).findFirst().orElse(null);

            if (genre == null) {
                resp.sendRedirect("/index");

            } else {
                req.setAttribute("name", genre.getName());
                List<Song> songs = songRepositoryJdbc.getByGenreId(genreId);
                req.setAttribute("songs", songs);

                req.getRequestDispatcher("/genres.ftl").forward(req, resp);
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
