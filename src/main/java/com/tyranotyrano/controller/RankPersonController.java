package com.tyranotyrano.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyranotyrano.rqrs.CreateRankPersonRq;
import com.tyranotyrano.service.RankPersonService;

@RequestMapping(path = "/redis/rank")
@RestController
public class RankPersonController {

    private final RankPersonService rankPersonService;

    public RankPersonController(RankPersonService rankPersonService) {
        this.rankPersonService = rankPersonService;
    }

    @PostMapping
    public void create(@RequestBody CreateRankPersonRq rq) {
        rankPersonService.create(rq);
    }
}
