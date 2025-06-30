package servlet;

import DAO.OptionDAO;
import config.HibernateFactory;
import org.hibernate.SessionFactory;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/deleteOption")
public class DeleteOptionServlet extends HttpServlet {
    private OptionDAO optionDAO;

    @Override
    public void init() {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        optionDAO = new OptionDAO(sessionFactory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            return;
        }

        UUID id = UUID.fromString(idParam);

        optionDAO.delete(id);
        response.sendRedirect(request.getHeader("Referer"));
    }
}