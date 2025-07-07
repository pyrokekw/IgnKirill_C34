package services;

import config.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import relationships.manyToMany.Course;
import relationships.manyToMany.Student;
import relationships.oneToMany.Department;
import relationships.oneToMany.Employee;
import relationships.oneToOne.User;

import java.util.UUID;

public class FindByIDService {

    private static final SessionFactory factory = Factory.
            getSessionFactory();


    public <T> T findByID(UUID id, Class<T> entityClass ) {
        Session session = factory.openSession();
        return session.find(entityClass, id);
    }

    /*

    Подумал, что здесь удобнее использовать дженерик, в сейве оставил. Но хз

    public User findUser(UUID id) {
        Session session = factory.openSession();
        return session.find(User.class, id);
    }

    public Department findDepartment(UUID id) {
        Session session = factory.openSession();
        return session.find(Department.class, id);
    }

    public Employee findEmployee(UUID id) {
        Session session = factory.openSession();
        return session.find(Employee.class, id);
    }

    public Student findStudent(UUID id) {
        Session session = factory.openSession();
        return session.find(Student.class,id);
    }

    public Course findCourse(UUID id) {
        Session session = factory.openSession();
        return session.find(Course.class, id);
    }

     */
}
