package com.baiwang.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.beans.factory.BeanFactory;

import java.lang.annotation.Annotation;

public class AbstractBeanFactoryAwareAdvisingPostProcessorTest extends AbstractBeanFactoryAwareAdvisingPostProcessor {

    private Class<? extends Annotation> annotationType;

    private MethodInterceptor methodInterceptor;

    public AbstractBeanFactoryAwareAdvisingPostProcessorTest() {
    }

    public AbstractBeanFactoryAwareAdvisingPostProcessorTest(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        setBeforeExistingAdvisors(true);
        AbstractPointcutAdvisorTest pointcut = new AbstractPointcutAdvisorTest(ATest.class, methodInterceptor);
        pointcut.setBeanFactory(beanFactory);
        this.advisor = pointcut;
    }
}
