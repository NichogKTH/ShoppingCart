package ui.servlet;

import ui.ItemInfo;
import ui.ItemInfoHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TestServlet")
public class AuthenticationServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("num1");
        String password = req.getParameter("num2");

        ItemInfoHandler itemInfoHandler = new ItemInfoHandler();
        boolean authenticated = false;
        if (itemInfoHandler.noOfAuthentications() != 0 || true) {
            for (int i = 0; i < itemInfoHandler.noOfAuthentications(); i++) {
                ItemInfo itemInfo = itemInfoHandler.getAuthentication(i);
                if (itemInfo.getName().equals(username) && itemInfo.getDescription().equals(password))
                    authenticated = true;
            }
        }

        PrintWriter out = res.getWriter();
        out.println("<html>");
        if (authenticated) {
            Cookie authentication = new Cookie("authenticated", "yes");
            authentication.setMaxAge(900);
            res.addCookie(authentication);
            res.sendRedirect("http://localhost:8080/Tutorial3/");
        } else {
            res.addCookie(new Cookie("authenticated", "no"));
            res.sendRedirect("http://localhost:8080/Tutorial3/");
        }
        out.println("<Button href=\"http://localhost:8080/Tutorial3/\">Return</Button>");
        out.println("</html>");

    }
}