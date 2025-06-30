package servlet;

import DAO.PollDAO;
import DAO.OptionDAO;
import config.HibernateFactory;
import entity.Option;
import entity.Poll;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/editPoll")
public class EditPollServlet extends HttpServlet {

    private PollDAO pollDAO;
    private OptionDAO optionDAO;

    @Override
    public void init(ServletConfig config) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        pollDAO = new PollDAO(sessionFactory);
        optionDAO = new OptionDAO(sessionFactory);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            return;
        }

        UUID id = UUID.fromString(idParam);
        Poll poll = pollDAO.findById(id);

        if (poll == null) {
            return;
        }

        List<Option> options = optionDAO.findByPollId(id);
        request.setAttribute("poll", poll);
        request.setAttribute("options", options);
        request.getRequestDispatcher("editPoll.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        UUID id = UUID.fromString(idParam);
        String title = req.getParameter("title");
        Poll poll = pollDAO.findById(id);
        poll.setTitle(title);
        pollDAO.update(poll);
        resp.sendRedirect("polls");
    }
}
