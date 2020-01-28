package main.com.team3d.busTravelingSystem.Servlet;

import main.com.team3d.busTravelingSystem.Persistent.DbContext.HibernateUtil;
import main.com.team3d.busTravelingSystem.Persistent.Models.Role;
import main.com.team3d.busTravelingSystem.Persistent.Models.User;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@WebServlet(name = "loginServlet" , urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserRepository userRepository = UserRepository.getInstance();
        ArrayList<User> users = userRepository.findAll().stream().filter(u->u.getUsername().equals(username) && u.getPassword().equals(password)).collect(Collectors.toCollection(ArrayList::new));
        if(users.size()==1)
        {

            List<Role> roles = users.get(0).getRoles().stream().filter(r->r.getTitle().equals("admin")).collect(Collectors.toList());
            if(roles.size()==1){
                HttpSession session = request.getSession();
                session.setAttribute("username",users.get(0).getUsername());
                session.setAttribute("name",users.get(0).getFirstName());
                session.setAttribute("family",users.get(0).getLastName());
                session.setAttribute("role",roles.get(0).getTitle());
                response.sendRedirect("AdminPage.jsp");

            }
            else {
                HttpSession session = request.getSession();
                session.setAttribute("username",users.get(0).getUsername());
                session.setAttribute("name",users.get(0).getFirstName());
                session.setAttribute("family",users.get(0).getLastName());
                response.sendRedirect("UserPage.jsp");
            }
        }
        else {
            String wi="oOOops! user not found! enter your info again!";
            request.setAttribute("wi",wi);
            request.getRequestDispatcher("Login.jsp").forward(request,response);

        }
    }

}
