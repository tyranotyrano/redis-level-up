package com.tyranotyrano.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.tyranotyrano.domain.Person;
import com.tyranotyrano.domain.PersonInMemoryRepository;
import com.tyranotyrano.rqrs.CreateStringCacheRq;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CacheRedisService {

    private final StringRedisTemplate stringRedisTemplate;

    @Cacheable(value = "fixed-key")
    public String findByKey(String key) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public void create(CreateStringCacheRq rq) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(rq.getKey(), rq.getValue());
    }

    @CacheEvict(value = "fixed-key")
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    @Cacheable(value = "person", key = "#name")
    public Person findPerson(String name) {
        return PersonInMemoryRepository.getPerson(name);
    }
}
