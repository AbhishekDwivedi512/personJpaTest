package com.example.demo.service.serviceimplementation;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.ServiceMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImplementation implements ServiceMethods {

    @Autowired
    PersonRepository personRepository ;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> findById(int uid) {
        return personRepository.findById(uid);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findAllByOrderByAgeAsc() {
        return personRepository.findAll(
                Sort.by(Sort.Direction.ASC, "uid")
        );
    }

    @Override
    public Person delete(int uid) {
        return personRepository.deleteById(uid);
    }

    @Override
    public Person Update(int uid,Person person) {
        person.setUid(uid);
       Person esisting = personRepository.findById(uid).orElseThrow(() -> new RuntimeException("No id is found"));
       esisting.setUid(person.getUid());
       esisting.setName(person.getName());
       esisting.setAge(person.getAge());
       esisting.setEmail(person.getEmail());
       esisting.setLoc(person.getLoc());

       return personRepository.save(esisting);
    }


}
