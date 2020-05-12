package com.baiwang.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
public class ConfigTest {

    @Bean
    public AbstractBeanFactoryAwareAdvisingPostProcessorTest abstractBeanFactoryAwareAdvisingPostProcessorTest() {
        return new AbstractBeanFactoryAwareAdvisingPostProcessorTest();
    }

    @Bean
    public MethodInterceptorTest methodInterceptorTest() {
        return new MethodInterceptorTest();
    }

    @Bean
    public TestService testService() {
        return new TestServiceB();
    }
}
