package com.example.hibernate_hw.repository;

import com.example.hibernate_hw.entity.Person;
import com.example.hibernate_hw.entity.PersonNameSurname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonByCityRepository extends JpaRepository<Person, PersonNameSurname> {
    @Query("select p from Person p where p.cityOfLiving = :cityOfLiving")
    List<Person> findByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);
    @Query(value = "select p from Person p where p.nameSurname.age < :age order by p.nameSurname.age asc")
    List<Person> findByNameSurname_AgeLessThanOrderByNameSurname_AgeAsc(@Param("age") int age);

    @Query(value = "select p from Person p where p.nameSurname.name = :name and p.nameSurname.surname = :surname")
    List<Person> findByNameSurname_NameAndNameSurname_Surname(@Param("name") Optional<String> name, @Param("surname") Optional<String> surname);
}
