/**
 * @author Gilyazov Marat
 * 11-905
 */

package controller;

import models.entities.Song;
import models.repositories.SongRepositoryJdbc;
import models.repositories.UserRepositoryJdbc;

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
        SongRepositoryJdbc songRepositoryJdbc = new SongRepositoryJdbc((Connection) req.getServletContext().getAttribute("connection"));
        List<Song> songs = songRepositoryJdbc.getAll();
        System.out.println(songs);
        req.setAttribute("songs", songs);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jsp/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
