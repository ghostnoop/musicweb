/**
 * @author Gilyazov Marat
 * 11-905
 */

package controllers.servlets.filesworkers;

import app.Constants;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = {"/img/get", "/mp3/get"})
public class FileDistributionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("name");

        if (req.getRequestURI().equals("/img/get")) {
            resp.setContentType("image/png");
        } else {
            resp.setContentType("audio/mpeg");
        }

        try {

        IOUtils.copyLarge(
                new FileInputStream(Constants.upload_dir + File.separator + filename),
                resp.getOutputStream()
        );
        }
        catch (IOException ioExp){
            ioExp.printStackTrace();
        }

    }
}
