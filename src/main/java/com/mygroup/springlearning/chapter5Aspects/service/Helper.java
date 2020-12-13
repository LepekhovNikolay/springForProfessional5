package com.mygroup.springlearning.chapter5Aspects.service;

import com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.methodInterceptor.ProfilingInterceptor;
import com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.methodInterceptor.WorkerBean;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;

public class Helper {
    public static <T> T getProxy(T target, Advisor advisor) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisor(advisor);

        @SuppressWarnings("unchecked")
        T proxy = (T) factory.getProxy();
        return proxy;
    }

    public static <T> T getProxy(T target, Advice advice) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);
        @SuppressWarnings("unchecked")
        T proxy = (T) factory.getProxy();
        return proxy;
    }
}
