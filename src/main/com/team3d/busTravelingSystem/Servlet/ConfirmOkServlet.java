package main.com.team3d.busTravelingSystem.Servlet;

import main.com.team3d.busTravelingSystem.Persistent.Models.Ticket;
import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;
import main.com.team3d.busTravelingSystem.Persistent.Models.User;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.TicketRepository;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.TravelRepository;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/ConfirmOk")
public class ConfirmOkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String gender = request.getParameter("op");
        //travel part
        Long travelId = (Long) request.getSession().getAttribute("tid");
        TravelRepository travelRepository = TravelRepository.getInstance();
        Travel travel = travelRepository.findById(travelId);
        //user part
        String username = (String) request.getSession().getAttribute("username");
        UserRepository userRepository = UserRepository.getInstance();
        List<User> users = userRepository.findAll().stream().filter(u->u.getUsername().equals(username)).collect(Collectors.toList());
        User user = users.get(0);
        //set ticket attributes
        Ticket ticket = new Ticket();
        ticket.setSex(gender);
        ticket.setTravel(travel);
        ticket.setUser(user);
        TicketRepository ticketRepository = TicketRepository.getInstance();
        Ticket savedTicket = ticketRepository.save(ticket);
        request.getSession().setAttribute("ticketId",savedTicket.getId());
        request.getSession().setAttribute("gender",savedTicket.getSex());
        request.getRequestDispatcher("Reserved.jsp").forward(request,response);





    }
}
