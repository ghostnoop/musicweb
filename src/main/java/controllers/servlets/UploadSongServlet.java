/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@MultipartConfig
@WebServlet(urlPatterns = "/uploadsong")
public class UploadSongServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("track_name"); // Retrieves <input type="text" name="description">


        String uploadDir = getServletConfig().getInitParameter("uploadDir");
        Part file = req.getPart("track_img");

        IOUtils.copyLarge(
                file.getInputStream(),
                new FileOutputStream(uploadDir +
                        File.separator +
                        UUID.randomUUID().toString() +
                        "-" +
                        file.getSubmittedFileName()
                )
        );
    }
}
