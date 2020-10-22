/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets.detail;

import models.entities.Album;
import models.repositories.AlbumRepositoryJdbc;

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
            AlbumRepositoryJdbc albumRepositoryJdbc = new AlbumRepositoryJdbc(dataSource);
            List<Album> albums = albumRepositoryJdbc.getAll();
            req.getRequestDispatcher("/details/albumpage.ftl").forward(req, resp);



        } catch (NumberFormatException except) {
            resp.sendRedirect("/404");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
