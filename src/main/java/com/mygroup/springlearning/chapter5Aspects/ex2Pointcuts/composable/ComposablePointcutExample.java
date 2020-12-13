package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.composable;

import com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.controlFlow.SimpleBeforeAdvice;
import com.mygroup.springlearning.chapter5Aspects.service.GrammyGuitarist;
import com.mygroup.springlearning.chapter5Aspects.service.Guitar;
import com.mygroup.springlearning.chapter5Aspects.service.Helper;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

public class ComposablePointcutExample {
    public static void main(String[] args) {
        GrammyGuitarist johnMayer = new GrammyGuitarist();
        ComposablePointcut pointcut = new ComposablePointcut(
                ClassFilter.TRUE, new SingMethodMatcher());
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
        GrammyGuitarist proxy;

        System.out.println("Test 1 - sing methods matching >>");
        proxy = Helper.getProxy(johnMayer, advisor);
        testInvoke(proxy);
        System.out.println();

        System.out.println("Test 2 - (talk || sing) methods matching >>");
        pointcut.union(new TalkMethodMatcher());
        proxy = Helper.getProxy(johnMayer, advisor);
        testInvoke(proxy);
        System.out.println();

        System.out.println("Test 3 - (rest && sing) methods matching >>");
        pointcut.intersection(new RestMethodMatcher());
        proxy = Helper.getProxy(johnMayer, advisor);
        testInvoke(proxy);
        System.out.println();
    }

    private static void testInvoke(GrammyGuitarist proxy) {
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.talk();
        proxy.rest();
    }

    private static class SingMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return method.getName().startsWith("si");
        }
    }

    private static class TalkMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return "talk".equals(method.getName());
        }
    }

    private  static class RestMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return method.getName().endsWith("st");
        }
    }
}
