package com.tyranotyrano.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import com.tyranotyrano.domain.rank.RankPerson;
import com.tyranotyrano.domain.rank.RankPersonRepository;
import com.tyranotyrano.rqrs.CreateRankPersonRq;

@Service
public class RankPersonService {
    private static final String RANK_KEY = "RANK";

    private final RedisTemplate<String, RankPerson> redisTemplate;
    private final RankPersonRepository rankPersonRepository;

    public RankPersonService(
        RedisTemplate<String, RankPerson> redisTemplate, RankPersonRepository rankPersonRepository) {
        this.redisTemplate = redisTemplate;
        this.rankPersonRepository = rankPersonRepository;
    }

    public void create(CreateRankPersonRq rq) {
        RankPerson rankPerson = rankPersonRepository.save(rq.toRankPerson());

        ZSetOperations<String, RankPerson> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(RANK_KEY, rankPerson, rankPerson.getScore());
    }

    public List<RankPerson> findAll() {
        List<RankPerson> rankPersons = new ArrayList<>();
        ZSetOperations<String, RankPerson> zSetOperations = redisTemplate.opsForZSet();
        rankPersons.addAll(zSetOperations.range(RANK_KEY, 0, 100));

        return rankPersons;
    }
}
