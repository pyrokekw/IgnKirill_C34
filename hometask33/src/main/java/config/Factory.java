package config;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import relationships.manyToMany.Course;
import relationships.manyToMany.Student;
import relationships.oneToMany.Department;
import relationships.oneToMany.Employee;
import relationships.oneToOne.User;
import relationships.oneToOne.UserDetails;

import java.util.Properties;

public class Factory {
    public static SessionFactory getSessionFactory() {
        Properties props = new Properties();
        props.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/db_course");
        props.put("hibernate.connection.username", "postgres");
        props.put("hibernate.connection.password", "postgres");
        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.show_sql", "false");
        props.put("hibernate.format_sql", "false");

        return new Configuration()
                .addProperties(props)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetails.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }
}