package com.example.hibernate_hw.controller;

import com.example.hibernate_hw.entity.Person;
import com.example.hibernate_hw.repository.PersonByCityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonsByCityController {
    private PersonByCityRepository personByCityRepository;

    public PersonsByCityController(PersonByCityRepository personByCityRepository) {
        this.personByCityRepository = personByCityRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city){
        return personByCityRepository.getPersonsByCity(city);
    }
}
