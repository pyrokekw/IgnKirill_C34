package services;

import config.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import relationships.oneToMany.Department;
import relationships.oneToOne.User;

import java.util.UUID;

public class DepartmentService {

    private static final SessionFactory factory = Factory.
            getSessionFactory();

    public Department save(Department department) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(department);
        transaction.commit();
        session.close();

        return department;
    }

    public Department findByIDDepartment(UUID id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Department department = session.find(Department.class, id);
        transaction.commit();
        session.close();

        return department;
    }
}