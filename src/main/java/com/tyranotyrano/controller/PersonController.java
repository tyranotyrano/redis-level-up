package com.tyranotyrano.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyranotyrano.domain.person.Person;
import com.tyranotyrano.rqrs.CreatePersonRq;
import com.tyranotyrano.service.PersonService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/redis/person")
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public void createPerson(@RequestBody CreatePersonRq rq) {
        personService.createPerson(rq);
    }

    @GetMapping(path = "/{id}")
    public String findPerson(@PathVariable(name = "id") Long id) {
        Person person = personService.findPerson(id);
        return person.getName() + person.getAge();
    }

    @DeleteMapping(path = "/{id}")
    public void deletePerson(@PathVariable(name = "id") Long id) {
        personService.deletePerson(id);
    }
}
