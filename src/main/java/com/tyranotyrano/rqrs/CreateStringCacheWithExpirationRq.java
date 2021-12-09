package com.tyranotyrano.rqrs;

import java.util.concurrent.TimeUnit;

import lombok.Getter;

@Getter
public class CreateStringCacheWithExpirationRq {
    private String key;
    private String value;
    private long timeout;
    private TimeUnit timeUnit;
}
