package com.baiwang.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.Map;

public class MethodInterceptorTest implements MethodInterceptor {
    /**
     *
     * @param invocation 连接点
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        //获取目标类
        Class<?> targetClass = (invocation.getThis() != null ? AopUtils.getTargetClass(invocation.getThis()) : null);
        //获取指定方法
        Method specificMethod = ClassUtils.getMostSpecificMethod(invocation.getMethod(), targetClass);
        //获取真正执行的方法,可能存在桥接方法
        final Method userDeclaredMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);

        //获取方法上注解
        ATest aa = AnnotatedElementUtils.findMergedAnnotation(userDeclaredMethod, ATest.class);
        if (aa == null) {
            aa = AnnotatedElementUtils.findMergedAnnotation(userDeclaredMethod.getDeclaringClass(), ATest.class);
        }
        System.out.println(aa.value());
        //获取返回类型
        Class<?> returnType = invocation.getMethod().getReturnType();
        //返回类型判断

        System.out.println(returnType.getName());

        return invocation.proceed();
    }
}
