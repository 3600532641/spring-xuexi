package com.baiwang.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigTest.class);
        TestService bean = applicationContext.getBean(TestService.class);
        bean.pocess();
        applicationContext.close();

    }
}
