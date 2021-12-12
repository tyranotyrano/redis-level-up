package com.tyranotyrano.rqrs;

import lombok.Getter;

@Getter
public class CreateCacheRq {
    private String key;
    private Object value;
}
