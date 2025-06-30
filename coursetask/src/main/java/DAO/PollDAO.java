package DAO;

import entity.Poll;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class PollDAO {

    private final SessionFactory sessionFactory;

    public PollDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Poll poll) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(poll);
        transaction.commit();
        session.close();
    }

    public List<Poll> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("FROM Poll WHERE isActive = true", Poll.class).list();
    }

    public void delete(UUID id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Poll poll = session.get(Poll.class, id);
        poll.setActive(false);
        session.update(poll);
        transaction.commit();
        session.close();
    }

    public Poll findById(UUID id) {
        Session session = sessionFactory.openSession();
        return session.get(Poll.class, id);
    }

    public void update(Poll poll) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(poll);
        transaction.commit();
        session.close();
    }
}
