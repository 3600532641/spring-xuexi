package com.baiwang.test;

import com.baiwang.bean.Person;
import com.baiwang.config.MainConfig;
import com.baiwang.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * 描述
 *
 * @author
 */
public class IOCTest {

    public static ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test3() {
        print(context);
    }

    public void print(ApplicationContext context) {
        Map<String, Person> beans = context.getBeansOfType(Person.class);
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("操作系统" + property);
        System.out.println(beans);
        System.out.println("---------------");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }


    @Test
    public void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("ioc容器创建完成。。。。。");
//        Person bean = context.getBean(Person.class);
//        Person bean2 = context.getBean(Person.class);
//        System.out.println(bean==bean2);

    }

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}