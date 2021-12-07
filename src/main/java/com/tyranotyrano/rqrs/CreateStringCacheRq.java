package com.tyranotyrano.rqrs;

import lombok.Getter;

@Getter
public class CreateStringCacheRq {
    private String key;
    private String value;
}
