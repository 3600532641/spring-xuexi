package com.baiwang;

import com.baiwang.bean.Person;
import com.baiwang.config.MainConfig;
import com.baiwang.config.MainConfig2;
import com.baiwang.config.MainConfig3;
import com.baiwang.config.MainConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

/**
 * 描述
 *
 * @author
 */
public class MainTest {
    public static void main(String[] args) {


//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        applicationContext.close();
//        Person person = applicationContext.getBean(Person.class);
//        System.out.println(person);
//        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
//        for (String name : beanNamesForType) {
//            System.out.println(name);
//        }
        //       System.out.println("abcd");
    }
}