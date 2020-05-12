package com.baiwang.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyPostCourt {

    @PostConstruct
    public void init(){
        System.out.println("MyPostCourt......init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("MyPostCourt......destroy");
    }
}
