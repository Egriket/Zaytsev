package servlet_image;

import org.junit.After;
import org.junit.Test;
import storage.Storage;

import storage.Storage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class ServletImageTest {

    @WebServlet(
            name = "servlet_image.ServletImage",
            urlPatterns = "/ServletImage"
    )
    public class ServletImage extends HttpServlet {
        private String lockalhost = "..";
        @Test
        @Override
        public void init() throws ServletException {
            super.init();
            File dir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
            File[] files = dir.listFiles();
            if (files != null) {
                for (File f : files) {
                    Storage.getImagesPath().add(f.getName());
                }
            }
            int size = 12;
            assertEquals(size, Storage.imagesPath.size());
        }

        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html><head><title>Image</title></head><body>");

                String image = (String) request.getSession().getAttribute("image");
                out.println("<div align=\"center\">");
                if (image != null){
                    out.println("<p><img src=" + "\""+ "/ImagesFun_war_exploded/" + image + "\" alt=\"Funny Image\"/> width=\"700\"</p>");

                }
                out.println("<form action=\"/ImagesFun_war_exploded/ServletImage\" method=\"post\">");
                out.println("<input type=\"submit\" value=\"show\">");
                out.println("</form>");
                out.println("</div>");
                out.println("</body></html>");
            } catch (IOException ex){
                ex.printStackTrace();
            }


        }

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            double imgNum = (Math.random()*10) % Storage.getImagesPath().size();

            req.getSession().setAttribute("image", Storage.getImagesPath().get((int) imgNum));

            resp.sendRedirect("/ImagesFun_war_exploded/ServletImage");
        }
    }
}