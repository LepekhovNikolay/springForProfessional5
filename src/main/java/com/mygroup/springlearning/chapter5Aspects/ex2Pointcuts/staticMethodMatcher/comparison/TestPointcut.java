package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.comparison;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class TestPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "advise".equals(method.getName());
    }
}
