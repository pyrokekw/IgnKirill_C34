package services;

import config.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import relationships.manyToMany.Student;
import relationships.oneToOne.User;

import java.util.UUID;

public class StudentService {
    private static final SessionFactory factory = Factory.
            getSessionFactory();

    public Student save(Student student) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(student);
        transaction.commit();
        session.close();

        return student;
    }

    public Student findByID(UUID id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.find(Student.class, id);
        transaction.commit();
        session.close();

        return student;
    }
}
