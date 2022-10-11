package ui.servlet;

import ui.ItemInfoHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "add", value = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        ItemInfoHandler.addItemFromStoreToCart(id, name, description);
        response.sendRedirect("http://localhost:8080/Tutorial3/");
    }
}
