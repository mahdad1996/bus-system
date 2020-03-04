package main.com.team3d.busTravelingSystem.Servlet;

import main.com.team3d.busTravelingSystem.Persistent.Models.User;
import main.com.team3d.busTravelingSystem.Persistent.Repositories.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
@WebServlet(name = "SignupServlet",urlPatterns = "/Signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        UserRepository userRepository = UserRepository.getInstance();
        User u = userRepository.save(new User(username,password,email,firstName,lastName));
        if(u!=null){
            String message = "Sign Up Completed!You can Login now!";
            request.getSession().setAttribute("mok",message);
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }


    }
}
