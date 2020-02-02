package main.com.team3d.busTravelingSystem.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Confirm")
public class ConfirmTicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String travelId = request.getParameter("tid");
        Long tid = Long.parseLong(travelId);
        request.getSession().setAttribute("tid",tid);

        request.getRequestDispatcher("ConfirmReserve.jsp").forward(request,response);

    }
}
