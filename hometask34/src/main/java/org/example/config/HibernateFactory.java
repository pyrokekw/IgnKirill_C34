package org.example.config;

import org.example.entity.CarEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateFactory {
    public static SessionFactory getSessionFactory() {
        Properties props = new Properties();
        props.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        props.put("hibernate.connection.username", "postgres");
        props.put("hibernate.connection.password", "postgres");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");

        return new Configuration()
                .addProperties(props)
                .addAnnotatedClass(CarEntity.class)
                .buildSessionFactory();
    }
}
