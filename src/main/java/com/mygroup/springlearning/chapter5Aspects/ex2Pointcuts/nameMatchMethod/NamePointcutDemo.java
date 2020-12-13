package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.nameMatchMethod;

import com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.simple.SimpleAdvice;
import com.mygroup.springlearning.chapter5Aspects.service.GrammyGuitarist;
import com.mygroup.springlearning.chapter5Aspects.service.Guitar;
import com.mygroup.springlearning.chapter5Aspects.service.Helper;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class NamePointcutDemo {
    public static void main(String[] args) {
        GrammyGuitarist johnMayer = new GrammyGuitarist();
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("sing");
        pointcut.addMethodName("rest");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        GrammyGuitarist proxy = Helper.getProxy(johnMayer, advisor);
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }
}
