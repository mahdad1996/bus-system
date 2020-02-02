package main.com.team3d.busTravelingSystem.Servlet;

import main.com.team3d.busTravelingSystem.Persistent.Models.Ticket;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.TicketRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteTicket")
public class DeleteTicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketRepository ticketRepository = TicketRepository.getInstance();
        Ticket ticket = (Ticket) request.getSession().getAttribute("tDetailsID");
        ticketRepository.remove(ticket);
        request.getRequestDispatcher("UserPage.jsp").forward(request,response);

    }
}
