package com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.afterReturning.keyChecker;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import static com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.afterReturning.keyChecker.KeyGenerator.WEAK_KEY;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if ((target instanceof KeyGenerator)
        && ("getKey".equals(method.getName()))) {
            long key = (Long) returnValue;

            if (key == WEAK_KEY) {
                throw new SecurityException("Key Generator generated a weak key. Try again");
            }

        }
    }
}
