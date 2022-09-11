package com.listener.jms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.listener.jms.models.Person;
import com.listener.jms.repository.PersonRepository;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;  
    
    
    @GetMapping("/persons")
    public ResponseEntity<?> persons() {
        List<Person> persons = personRepository.findAll();
        return ResponseEntity.ok().body(persons);
    }

}

