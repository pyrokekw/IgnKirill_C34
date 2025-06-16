package services;

import config.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import relationships.manyToMany.Student;
import relationships.oneToMany.Department;
import relationships.oneToOne.User;

public class SaveService {
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

    public Department save(Department department) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(department);
        transaction.commit();
        session.close();

        return department;
    }

    public Student save(Student student) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(student);
        transaction.commit();
        session.close();

        return student;
    }
}
