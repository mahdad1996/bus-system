package main.com.team3d.busTravelingSystem.Servlet;

import main.com.team3d.busTravelingSystem.Persistent.Models.Ticket;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.TicketRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TicketDetails")
public class ShowTicketDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ticketId = request.getParameter("ticketIdForDetails");
        Long tid = Long.parseLong(ticketId);
        TicketRepository ticketRepository = TicketRepository.getInstance();
        Ticket ticket = ticketRepository.findById(tid);
        request.getSession().setAttribute("tDetailsID",ticket);
        request.getRequestDispatcher("ShowTicketDetails.jsp").forward(request,response);

    }
}
