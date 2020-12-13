package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.jdkRegexpMethod;

import com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.simple.SimpleAdvice;
import com.mygroup.springlearning.chapter5Aspects.service.Guitarist;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class RegexpPointcutDemo {
    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*sing.*");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(johnMayer);
        factory.addAdvisor(advisor);
        Guitarist proxy = (Guitarist) factory.getProxy();

        proxy.sing();
        proxy.sing2();
        proxy.rest();
    }
}
