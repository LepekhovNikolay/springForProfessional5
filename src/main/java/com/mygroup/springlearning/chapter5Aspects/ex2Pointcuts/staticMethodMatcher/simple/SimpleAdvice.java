package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.simple;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(">> Invocing " + invocation.getMethod().getName());
        Object retVal = invocation.proceed();
        System.out.println(">> Done" + System.lineSeparator());
        return retVal;
    }
}
