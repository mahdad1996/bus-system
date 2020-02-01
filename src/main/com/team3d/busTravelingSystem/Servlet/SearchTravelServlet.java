package main.com.team3d.busTravelingSystem.Servlet;

import main.com.team3d.busTravelingSystem.Domain.Services.ShowTravelsByUser;
import main.com.team3d.busTravelingSystem.Persistent.Models.Travel;
import main.com.team3d.busTravelingSystem.util.MyDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/Search")
public class SearchTravelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String source= request.getParameter("source");
        String dest = request.getParameter("destination");
        String date = request.getParameter("date");

        ShowTravelsByUser showTravelsByUser=new main.com.team3d.busTravelingSystem.Domain.ShowTravelsByUser();
        List<Travel> travels = showTravelsByUser.Show();
        for (Travel t : travels){

            Date fstdate = t.getDate();
            t.setPersianDate(MyDate.changeFromGeorgian(fstdate));



        }
        List<Travel> searchResult = travels.stream().filter(travel -> travel.getSource().equals(source) && travel.getDestination().equals(dest) && travel.getPersianDate().equals(date)).collect(Collectors.toList());
        searchResult.sort((o1, o2) -> o2.compare(o1,o2));

        request.setAttribute("listTravels",searchResult);

        request.getRequestDispatcher("UserPage.jsp").forward(request,response);
    }
}
