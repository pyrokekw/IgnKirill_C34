package DAO;

import entity.Option;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
import java.util.UUID;

public class OptionDAO {

    private final SessionFactory sessionFactory;

    public OptionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Option option) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(option);
        transaction.commit();
        session.close();
    }

    public List<Option> findByPollId(UUID pollId) {
        Session session = sessionFactory.openSession();
            return session
                    .createQuery("FROM Option WHERE pollId = :pollId AND isActive = true", Option.class)
                    .setParameter("pollId", pollId)
                    .list();
    }

    public void delete(UUID id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Option option = session.get(Option.class, id);
        option.setActive(false);
        session.update(option);
        transaction.commit();
        session.close();
    }
}
