package com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.throwsAdvice;

import com.mygroup.springlearning.chapter5Aspects.service.Helper;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {
    public static void main(String[] args) {
        ErrorBean proxy = Helper.getProxy(new ErrorBean(), new SimpleThrowsAdvice());
        try {
            proxy.errorProneMethod();
        } catch (Exception ignored) {
        }

        try {
            proxy.otherErrorProneMethod();
        } catch (IllegalArgumentException e) {
        }
    }

    public void afterThrowing(Exception ex) throws  Throwable {
        System.out.println("****");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***" + System.lineSeparator());
    }

    public void afterThrowing(Method method, Object[] args,
                              Object target, IllegalArgumentException ex) {
        System.out.println("****");
        System.out.println("IllegalArgument Exception Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***" + System.lineSeparator());
    }
}
