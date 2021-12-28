package com.tyranotyrano.domain.rank;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rank_person")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RankPerson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int score;

    private RankPerson(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static RankPerson of(String name, int score) {
        return new RankPerson(name, score);
    }
}
