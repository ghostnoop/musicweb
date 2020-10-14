/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets.detail;

import app.Utils;
import models.entities.Song;
import models.repositories.SongRepositoryJdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/detail/song")
public class DetailSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("id");
        try {
            int songId = Integer.parseInt(s);
            DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");
            SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc(dataSource);

            Song song = songRepositoryJdbc.getById(songId);

//            todo get count of likes


            req.setAttribute("song",song);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/details/musicpage.ftl");
            requestDispatcher.forward(req, resp);


        } catch (NumberFormatException exp) {
            resp.sendRedirect("/404");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
