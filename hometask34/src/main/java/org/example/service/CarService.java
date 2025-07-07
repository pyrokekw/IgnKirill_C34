package org.example.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.DTO.SearchDTO;
import org.example.config.HibernateFactory;
import org.example.entity.CarEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private static final SessionFactory factory = HibernateFactory
            .getSessionFactory();

    public CarEntity save(CarEntity car) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(car);
        transaction.commit();
        session.close();

        return car;
    }

    public List<CarEntity> search(SearchDTO searchDTO) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CarEntity> query = builder.createQuery(CarEntity.class);
        Root<CarEntity> car = query.from(CarEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (searchDTO.getBrand() != null) {
            predicates.add(builder.equal(car.get("brand"), searchDTO.getBrand()));
        }

        if (searchDTO.getFromPrice() != null) {
            predicates.add(builder.ge(car.get("price"), searchDTO.getFromPrice()));
        }

        if (searchDTO.getToPrice() != null) {
            predicates.add(builder.le(car.get("price"), searchDTO.getToPrice()));
        }

        if (searchDTO.getFormMileage() != null) {
            predicates.add(builder.ge(car.get("mileage"), searchDTO.getFormMileage()));
        }

        if (searchDTO.getToMileage() != null) {
            predicates.add(builder.le(car.get("mileage"), searchDTO.getToMileage()));
        }

        if (searchDTO.getFromYear() != null) {
            predicates.add(builder.ge(car.get("year"), searchDTO.getFromYear()));
        }

        query.where(builder.and(predicates.toArray(new Predicate[0])));


        List<CarEntity> result = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();

        return result;
    }
}
