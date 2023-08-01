package com.example.hibernate_hw.controller;

import com.example.hibernate_hw.entity.Person;
import com.example.hibernate_hw.repository.PersonByCityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsByCityController {
    private final PersonByCityRepository personByCityRepository;

    public PersonsByCityController(PersonByCityRepository personByCityRepository) {
        this.personByCityRepository = personByCityRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city){
        return personByCityRepository.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age-less-than")
    public List<Person> getPersonsByAgeLessThan(@RequestParam("age") int age){
        return personByCityRepository.findByNameSurname_AgeLessThanOrderByNameSurname_AgeAsc(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public List<Person> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname){
        return personByCityRepository.findByNameSurname_NameAndNameSurname_Surname(name.describeConstable(), surname.describeConstable());
    }
}
