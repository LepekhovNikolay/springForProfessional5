package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.controlFlow;

import com.mygroup.springlearning.chapter5Aspects.service.Helper;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowDemo {
    public static void main(String[] args) {
        ControlFlowDemo ex = new ControlFlowDemo();
        ex.run();
    }

    private void run() {
        TestBean target = new TestBean();
        Pointcut pointcut = new ControlFlowPointcut(ControlFlowDemo.class, "test");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());

        TestBean proxy = Helper.getProxy(target, advisor);
        System.out.println("\tTrying normal invoke");
        proxy.foo();
        System.out.println(System.lineSeparator()
                + "\tTrying under ControlFlowDemo.test()");
        test(proxy);
    }

    private void test(TestBean proxy) {
        proxy.foo();
    }
}
