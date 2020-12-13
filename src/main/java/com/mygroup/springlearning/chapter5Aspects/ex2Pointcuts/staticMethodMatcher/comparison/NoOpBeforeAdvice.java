package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.comparison;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class NoOpBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
    }
}
