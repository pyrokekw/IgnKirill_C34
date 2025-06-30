package servlet;

import DAO.PollDAO;
import config.HibernateFactory;
import entity.Poll;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import java.io.IOException;
import java.util.List;

@WebServlet("/polls")
public class PollServlet extends HttpServlet {
    private PollDAO pollDAO;

    @Override
    public void init() {
        System.out.println(">>> PollServlet инициализирован");
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        pollDAO = new PollDAO(sessionFactory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       List<Poll> polls = pollDAO.findAll();
       req.setAttribute("polls", polls);
       req.getRequestDispatcher("polls.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String title = req.getParameter("title");
        Poll poll = new Poll();
        poll.setTitle(title);
        pollDAO.save(poll);
        resp.sendRedirect("polls");
    }
}

