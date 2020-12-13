package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.simple;

import com.mygroup.springlearning.chapter5Aspects.service.GoodGuitarist;
import com.mygroup.springlearning.chapter5Aspects.service.GreatGuitarist;
import com.mygroup.springlearning.chapter5Aspects.service.Helper;
import com.mygroup.springlearning.chapter5Aspects.service.Singer;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
    public static void main(String[] args) {
        GoodGuitarist johnMayer = new GoodGuitarist();
        GreatGuitarist ericClapton = new GreatGuitarist();

        Advisor advisor = new DefaultPointcutAdvisor(
                new SimpleStaticPointcut(),
                new SimpleAdvice());

        Singer proxyOne = Helper.getProxy(johnMayer, advisor);
        Singer proxyTwo = Helper.getProxy(ericClapton, advisor);

        proxyOne.sing();
        proxyTwo.sing();
    }
}
