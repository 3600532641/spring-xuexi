package com.baiwang.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import java.lang.annotation.Annotation;

public class AbstractPointcutAdvisorTest extends AbstractPointcutAdvisor implements BeanFactoryAware {
    private Pointcut pointcut;

    private Advice advice;

    private BeanFactory beanFactory;

    public AbstractPointcutAdvisorTest(Class<? extends Annotation> annotationType, MethodInterceptor interceptor) {
        pointcut = buildPointcut(annotationType);
        advice = buildAdvice(interceptor);
    }

    private Pointcut buildPointcut(Class<? extends Annotation> annotationType) {
        ComposablePointcut result = null;

        Pointcut amp = new AnnotationMatchingPointcut(annotationType, true);
        Pointcut map = AnnotationMatchingPointcut.forMethodAnnotation(annotationType);

        if (result == null) {
            result = new ComposablePointcut(amp);
        }
        result.union(map);
        return result;
    }

    private Advice buildAdvice(MethodInterceptor interceptor) {
        return interceptor;
    }


    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
