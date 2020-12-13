package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.annotationMatching;

import com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.simple.SimpleAdvice;
import com.mygroup.springlearning.chapter5Aspects.service.Guitarist;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutDemo {
    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();

        AnnotationMatchingPointcut pointcut =
                AnnotationMatchingPointcut
                .forMethodAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(johnMayer);
        Guitarist proxy = (Guitarist) factory.getProxy();

        proxy.sing2();
        proxy.sing();
        proxy.rest();
    }
}
