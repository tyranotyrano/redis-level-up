package com.tyranotyrano.domain.person;

import java.util.ArrayList;
import java.util.List;

public class PersonInMemoryRepository {
    private static List<Person> persons = new ArrayList<>();

    static {
        persons.add(Person.of("홍길동", 20));
        persons.add(Person.of("임꺽정", 30));
        persons.add(Person.of("오바마", 40));
    }

    private PersonInMemoryRepository() {}

    public static Person getPerson(String name) {
        return persons.stream()
                      .filter(p -> p.getName().equals(name))
                      .findAny()
                      .orElseThrow();
    }
}
