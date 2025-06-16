package services;

import config.Factory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import relationships.oneToOne.User;

import java.util.UUID;

public class UserService {

    private static final SessionFactory factory = Factory.
            getSessionFactory();

    public User save(User user) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(user);
        transaction.commit();
        session.close();

        return user;
    }

    public User findByID(UUID id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.find(User.class, id);
        transaction.commit();
        session.close();

        return user;
    }

}
