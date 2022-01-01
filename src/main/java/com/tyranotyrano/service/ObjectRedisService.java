package com.tyranotyrano.service;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.tyranotyrano.rqrs.CreateCacheRq;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObjectRedisService {
    private static String HASH_KEY = "HASH_KEY";

    private final RedisTemplate<String, Object> redisTemplate;

    public Object findByKey(String key) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public void create(CreateCacheRq rq) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(rq.getKey(), rq.getValue());
    }

    public void add(CreateCacheRq rq) {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        listOperations.leftPush(rq.getKey(), rq.getValue());
    }

    public List<Object> findAll(String key) {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        return listOperations.range(key, 0, listOperations.size(key));
    }

    public void addHash(CreateCacheRq rq) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(rq.getKey(), HASH_KEY, rq.getValue());
    }

    public Object findAllHash(String key) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(key, HASH_KEY);
    }
}
