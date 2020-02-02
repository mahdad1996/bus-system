package main.com.team3d.busTravelingSystem.Servlet;

import main.com.team3d.busTravelingSystem.Persistent.Models.Ticket;
import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.TicketRepository;
import main.com.team3d.busTravelingSystem.util.MyDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/ShowTickets")
public class ShowTicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = (String) request.getSession().getAttribute("username");
        TicketRepository ticketRepository = TicketRepository.getInstance();
        List<Ticket> tickets = ticketRepository.findAll().stream().filter(t->t.getUser().getUsername().equals(username)).collect(Collectors.toList());
        for (Ticket t : tickets){

            Date fstdate = t.getTravel().getDate();
            t.getTravel().setPersianDate(MyDate.changeFromGeorgian(fstdate));


        }
        request.getSession().setAttribute("tickets",tickets);
        request.getRequestDispatcher("ShowTickets.jsp").forward(request,response);

    }
}
