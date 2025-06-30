package servlet;

import DAO.OptionDAO;
import config.HibernateFactory;
import entity.Option;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/addOption")
public class AddOptionServlet extends HttpServlet {
    private OptionDAO optionDAO;

    @Override
    public void init() {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        optionDAO = new OptionDAO(sessionFactory);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pollIdParam = request.getParameter("pollId");
        String text = request.getParameter("text");

        if (pollIdParam == null || pollIdParam.isEmpty() || text == null || text.isEmpty()) {
            return;
        }

        UUID pollId = UUID.fromString(pollIdParam);
        Option option = new Option();
        option.setPollId(pollId);
        option.setText(text);
        optionDAO.save(option);
        response.sendRedirect("editPoll?id=" + pollId);
    }
}