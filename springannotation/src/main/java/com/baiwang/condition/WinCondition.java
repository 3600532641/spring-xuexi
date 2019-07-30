package com.baiwang.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 描述
 *
 * @author
 */
public class WinCondition implements Condition {

    //AnnotatedTypeMetadata metadata 当前类的注解信息
    //ConditionContext context上下文
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {



        //获取ioc容器
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取运行时变量
        Environment environment = context.getEnvironment();
        //获取操作系统
        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        System.out.println(property);
        return false;
    }
}