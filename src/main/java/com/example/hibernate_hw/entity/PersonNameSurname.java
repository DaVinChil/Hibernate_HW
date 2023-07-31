package com.example.hibernate_hw.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PersonNameSurname implements Serializable {
    private String name;
    private String surname;
    private int age;
}
