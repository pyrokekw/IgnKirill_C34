package web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;


import java.io.IOException;

@WebFilter("/admins")
public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String role = request.getParameter("role");
        if ("ADMIN".equalsIgnoreCase(role)) {
            chain.doFilter(request,response);
        }
        else {
            response.getWriter().write("Access denied. Only ADMIN role is allowed.");
        }


    }
}
