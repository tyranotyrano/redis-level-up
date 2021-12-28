package com.tyranotyrano.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tyranotyrano.domain.person.Person;
import com.tyranotyrano.domain.person.PersonRepository;
import com.tyranotyrano.rqrs.CreatePersonRq;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public void createPerson(CreatePersonRq rq) {
        personRepository.save(rq.toPerson());
    }

    @Cacheable(value = "person", key = "#id")
    public Person findPerson(Long id) {
        return personRepository.findById(id)
                               .orElseThrow(EntityNotFoundException::new);
    }

    @CacheEvict(value = "person", key = "#id")
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
