package com.example.hibernate_hw.repository;

import com.example.hibernate_hw.entity.Person;
import com.example.hibernate_hw.entity.PersonNameSurname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonByCityRepository extends JpaRepository<Person, PersonNameSurname> {
    List<Person> findByCityOfLiving(String cityOfLiving);
}
