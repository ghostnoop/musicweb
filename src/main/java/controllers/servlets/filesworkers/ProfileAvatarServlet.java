/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets.filesworkers;

import app.Utils;
import models.entities.Artist;
import models.entities.User;
import models.repositories.ArtistRepositoryJdbc;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@MultipartConfig
@WebServlet(value = "/changeavatar")
public class ProfileAvatarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/index");
            return;
        }

        DataSource dataSource = (DataSource) req.getServletContext().getAttribute("datasource");

        boolean isArtist = req.getSession().getAttribute("isArtist") != null;
        String avatar = Utils.fileSaver(req.getPart("avatar"));

        if (isArtist) {
            ArtistRepositoryJdbc artistRepositoryJdbc = new ArtistRepositoryJdbc(dataSource);
            Artist artist = (Artist) req.getSession().getAttribute("user");
            artist.setAvatar_img(avatar);
            artistRepositoryJdbc.updateById(artist, artist.getId());

        } else {
            UserRepositoryJdbc userRepositoryJdbc = new UserRepositoryJdbc(dataSource);
            User user = (User) req.getSession().getAttribute("user");
            user.setAvatar_img(avatar);
            userRepositoryJdbc.updateById(user, user.getId());
        }

        resp.sendRedirect("/profile");
    }
}
