package main.com.team3d.busTravelingSystem.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/AdminPage.jsp")
public class RoleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        if(session.getAttribute("role")!=null){
            if(session.getAttribute("role").equals("admin")) {
                filterChain.doFilter(request,response);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPage.jsp");
                dispatcher.forward(request, response);
            }
        }
        else {
            filterChain.doFilter(request,response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/UserPage.jsp");
            dispatcher.forward(request, response);
        }




    }
}
