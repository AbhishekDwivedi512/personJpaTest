package com.example.demo.service;

import com.example.demo.entity.Person;

import java.util.List;
import java.util.Optional;

public interface ServiceMethods {

    Person save (Person person);

    Optional<Person> findById(int uid);
    List<Person> findAll();

    List<Person> findAllByOrderByAgeAsc();

    Person delete(int uid);

    Person Update(int uid ,Person person);

}
