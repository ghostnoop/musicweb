package tests;

import com.google.gson.Gson;
import models.entities.Album;
import models.entities.Song;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchalbum")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("ZE WARDOO");

        /*String id = req.getParameter("id");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Song song = null;
        if (id.equals("1"))
            song  = Song.builder().title("test").album_id(Album.builder().title("test Album").build()).music_url("test.mp3").build();
        else if (id.equals("2"))
            song  = Song.builder().title("komety").album_id(Album.builder().title("komety Album").build()).music_url("komety.mp3").build();
        String json = new Gson().toJson(song);
        resp.getWriter().write(json);*/

        // album

        String id = req.getParameter("id");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        List<Song> song = new ArrayList<>();
        song.add(Song.builder().title("test").album_id(Album.builder().title("test Album").build()).music_url("test.mp3").build());
        song.add(Song.builder().title("komety").album_id(Album.builder().title("komety Album").build()).music_url("komety.mp3").build());
        String json = new Gson().toJson(song);
        resp.getWriter().write(json);
    }
}
