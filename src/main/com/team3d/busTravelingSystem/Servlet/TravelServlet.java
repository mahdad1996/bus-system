package main.com.team3d.busTravelingSystem.Servlet;

import main.com.team3d.busTravelingSystem.Domain.Services.AddTravelByAdmin;
import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;
import main.com.team3d.busTravelingSystem.util.MyDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.*;
import java.util.TimeZone;


@WebServlet(urlPatterns = "/AddTravel")
public class TravelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String dateOfTravel = request.getParameter("dateOfTravel");


        // SimpleDateFormat sdf = new SimpleDateFormat("");

       Date date = MyDate.changeFromJalali(dateOfTravel);

        String hourOfTravel = request.getParameter("hourOfTravel");

        AddTravelByAdmin addTravelByAdmin = new main.com.team3d.busTravelingSystem.Domain.ServiceImplementation.AddTravelByAdmin();
        addTravelByAdmin.Add(new Travel(source,destination,date,hourOfTravel));

        String message = "New Travel Saved!";
        request.getSession().setAttribute("adt",message);
        request.getRequestDispatcher("AdminPage.jsp").forward(request,response);

    }
}
