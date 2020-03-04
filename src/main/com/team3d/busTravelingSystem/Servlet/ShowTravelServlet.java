package main.com.team3d.busTravelingSystem.Servlet;

import com.github.eloyzone.jalalicalendar.DateConverter;
import com.github.eloyzone.jalalicalendar.JalaliDate;
import main.com.team3d.busTravelingSystem.Domain.Services.ShowTravels;
import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;
import main.com.team3d.busTravelingSystem.util.MyDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@WebServlet("/ShowTravels")
public class ShowTravelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShowTravels showTravels = new main.com.team3d.busTravelingSystem.Domain.ServiceImplementation.ShowTravels();

        List<Travel> travels = showTravels.show();
        for (Travel t : travels){

            Date fstdate = t.getDate();
            t.setPersianDate(MyDate.changeFromGeorgian(fstdate));


        }
        request.setAttribute("listTravels",travels);
        request.getRequestDispatcher("AdminPage.jsp").forward(request,response);
    }
}
