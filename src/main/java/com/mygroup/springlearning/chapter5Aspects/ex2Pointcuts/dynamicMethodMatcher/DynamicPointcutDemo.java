package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.dynamicMethodMatcher;

import com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.simple.SimpleAdvice;
import com.mygroup.springlearning.chapter5Aspects.service.Helper;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutDemo {
    public static void main(String[] args) {
        SampleBean target = new SampleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new SimplyDynamicPointcut(), new SimpleAdvice());


        SampleBean proxy = Helper.getProxy(target, advisor);

        proxy.foo(0);
        proxy.foo(10);
        proxy.foo(100);

        proxy.bar();
        proxy.bar();
        proxy.bar();
    }
}
