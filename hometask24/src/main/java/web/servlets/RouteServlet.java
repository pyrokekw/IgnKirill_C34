package web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.classes.Route;
import web.DB.DBService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/routes")
public class RouteServlet extends HttpServlet {

    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("PostgreSQL driver not found", e);
        }
    }
    private void handleAddRoute(HttpServletRequest req, PrintWriter out) throws SQLException {
        Route route = new Route();
        route.setName(req.getParameter("name"));
        route.setDescription(req.getParameter("desc"));
        route.setLength(Double.parseDouble(req.getParameter("length")));

        DBService.addRoute(route);
        out.println("Added route with ID: " + route.getId());
    }

    private void handleListRoutes(PrintWriter out) throws SQLException {
        List<Route> routes = DBService.getAllRoutes();
        if (routes.isEmpty()) {
            out.println("No routes available");
            return;
        }

        for (Route route : routes) {
            out.printf("%d. %s (%.1f km) - %d votes%n",
                    route.getId(), route.getName(),
                    route.getLength(), route.getVotes());
        }
    }

    private void handleVote(HttpServletRequest req, PrintWriter out) throws SQLException {
        int routeId = Integer.parseInt(req.getParameter("id"));
        String employeeId = (String) req.getAttribute("employeeId");

        if (DBService.voteForRoute(routeId, employeeId)) {
            out.println("Vote recorded successfully");
        } else {
            out.println("Error: You already voted for this route");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        String action = req.getParameter("action");

        try {
            switch (action) {
                case "add":
                    handleAddRoute(req, out);
                    break;
                case "list":
                    handleListRoutes(out);
                    break;
                case "vote":
                    handleVote(req, out);
                    break;
            }
        } catch (SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
