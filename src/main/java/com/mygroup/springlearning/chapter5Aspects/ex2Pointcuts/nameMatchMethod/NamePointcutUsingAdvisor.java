package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.nameMatchMethod;

import com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.simple.SimpleAdvice;
import com.mygroup.springlearning.chapter5Aspects.service.GrammyGuitarist;
import com.mygroup.springlearning.chapter5Aspects.service.Guitar;
import com.mygroup.springlearning.chapter5Aspects.service.Helper;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class NamePointcutUsingAdvisor {
    public static void main(String[] args) {
        GrammyGuitarist johnMayer = new GrammyGuitarist();

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        advisor.setMappedNames("sing");
        advisor.setMappedNames("rest");

        GrammyGuitarist proxy = Helper.getProxy(johnMayer, advisor);
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }
}
