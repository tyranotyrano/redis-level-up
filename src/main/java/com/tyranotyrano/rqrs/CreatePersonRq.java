package com.tyranotyrano.rqrs;

import com.tyranotyrano.domain.Person;

import lombok.Getter;

@Getter
public class CreatePersonRq {
    private String name;
    private int age;

    public Person toPerson() {
        return Person.of(name, age);
    }
}
