package com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.afterReturning.simple;

import com.mygroup.springlearning.chapter5Aspects.service.Guitarist;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
    public static void main(String[] args) {
        Guitarist target = new Guitarist();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(target);
        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing();
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After '" + method.getName() + "' put down guitar");
    }
}
