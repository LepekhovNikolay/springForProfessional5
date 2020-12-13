package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.simple;

import com.mygroup.springlearning.chapter5Aspects.service.GoodGuitarist;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
    @Override
    public ClassFilter getClassFilter() {
        return clazz -> clazz == GoodGuitarist.class;
    }



    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "sing".equals(method.getName());
    }
}
