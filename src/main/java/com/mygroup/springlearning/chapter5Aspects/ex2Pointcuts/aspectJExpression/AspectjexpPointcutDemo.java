package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.aspectJExpression;

import com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.simple.SimpleAdvice;
import com.mygroup.springlearning.chapter5Aspects.service.Guitarist;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Для работы среза AspectJ необходимо добавить зависимость в мавен
 */
public class AspectjexpPointcutDemo {
    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* sing* (..))");
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
