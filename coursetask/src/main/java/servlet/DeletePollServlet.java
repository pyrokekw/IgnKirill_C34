package servlet;

import DAO.PollDAO;
import config.HibernateFactory;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/deletePoll")
public class DeletePollServlet extends HttpServlet {
    private PollDAO pollDAO;

    @Override
    public void init() {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        pollDAO = new PollDAO(sessionFactory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            return;
        }

        UUID id = UUID.fromString(idParam);

        pollDAO.delete(id);
        response.sendRedirect("polls");
    }
}