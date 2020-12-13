package com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.afterReturning.keyChecker;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceDemo {
    private static KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new WeakKeyCheckAdvice());
        return (KeyGenerator) factory.getProxy();
    }

    public static void main(String[] args) {
        KeyGenerator keyGen = getKeyGenerator();

        for (int i = 0; i < 10; i++) {
            try {
                long key = keyGen.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException e) {
                System.out.println("Weak Key Generated!");;
            }
        }
    }
}
