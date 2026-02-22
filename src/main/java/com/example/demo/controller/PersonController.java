package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.ServiceMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    ServiceMethods serviceMethods;

    @PostMapping("/save")

    public Person save(@RequestBody Person person){

        return serviceMethods.save(person);
    }

    @PutMapping("/update/{uid}")

    public Person update(@PathVariable int uid,@RequestBody Person person){

        return serviceMethods.Update(uid,person);
    }







    @GetMapping("/give/{uid}")
    
    public Optional<Person> findById(@PathVariable int uid){
        return serviceMethods.findById(uid);
    }
    @GetMapping("Person/allPerson")

    public List<Person> findAll(@RequestBody Person person){
        return serviceMethods.findAll();
    }

    @GetMapping("Person/allbyasc")

    public List<Person> findAllbyAscorder(@RequestBody Person person){
        return serviceMethods.findAllByOrderByAgeAsc();
    }

    @DeleteMapping("Person/DeleteByID/{uid}")

    public Person deleteById(@PathVariable int uid){
        return serviceMethods.delete(uid);
    }

}
