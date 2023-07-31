package com.example.hibernate_hw.repository;

import com.example.hibernate_hw.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonByCityRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public PersonByCityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonsByCity(String city) {
        return (List<Person>) entityManager.createQuery("FROM Person WHERE cityOfLiving = :city")
                .setParameter("city", city)
                .getResultList();
    }
}
