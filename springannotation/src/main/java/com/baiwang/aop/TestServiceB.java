package com.baiwang.aop;

public class TestServiceB implements TestService {

    @ATest(value = "BBBBBB")
    @Override
    public void pocess() {
        System.out.println("TestServiceB");
    }
}
