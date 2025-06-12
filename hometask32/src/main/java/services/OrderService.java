package services;

import config.HibernateFactory;
import entity.OrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.UUID;

public class OrderService {

    private static final SessionFactory factory = HibernateFactory
            .getSessionFactory();

    public OrderEntity save(OrderEntity orderEntity) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(orderEntity);
        transaction.commit();
        session.close();

        return orderEntity;
    }
    public OrderEntity findByID(UUID id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        OrderEntity orderEntity = session.find(OrderEntity.class, id);
        transaction.commit();
        session.close();

        return orderEntity;
    }
}
