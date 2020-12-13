package com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.methodBefore.simple;

import com.mygroup.springlearning.chapter5Aspects.service.Guitarist;
import com.mygroup.springlearning.chapter5Aspects.service.Helper;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();
        Guitarist proxy = Helper.getProxy(johnMayer, new SimpleBeforeAdvice());
        proxy.sing();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before " + method.getName() + "', tune guitar.");
    }
}
