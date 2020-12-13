package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.dynamicMethodMatcher;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimplyDynamicPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public ClassFilter getClassFilter() {
        return clazz -> clazz == SampleBean.class;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static check for " + method.getName());
        return "foo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("Dynamic check for " + method.getName());
        int x = (Integer) args[0];
        return x != 100;
    }
}
