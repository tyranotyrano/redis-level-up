package com.tyranotyrano.rqrs;

import com.tyranotyrano.domain.rank.RankPerson;

import lombok.Getter;

@Getter
public class CreateRankPersonRq {
    private String name;
    private int score;

    public RankPerson toRankPerson() {
        return RankPerson.of(name, score);
    }
}
