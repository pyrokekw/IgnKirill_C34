package web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

            HttpServletRequest req = (HttpServletRequest) request;
            String employeeId = req.getHeader("X-Employee-ID") != null ?
                    req.getHeader("X-Employee-ID") :
                    req.getSession().getId();
            req.setAttribute("employeeId", employeeId);
            chain.doFilter(request, response);

    }


}
