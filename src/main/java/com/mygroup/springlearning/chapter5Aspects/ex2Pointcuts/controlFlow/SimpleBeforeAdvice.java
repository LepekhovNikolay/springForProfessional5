package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.controlFlow;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.text.MessageFormat;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        StringBuilder sb = new StringBuilder();
        sb.append("Before method: ");
        sb.append(method.getName());
        sb.append("(");
        for (Class<?> parameterType : method.getParameterTypes()) {
            sb.append(parameterType.getSimpleName());
            sb.append(" ");
            char firstLetter = parameterType.getSimpleName().charAt(0);
            sb.append(Character.toLowerCase(firstLetter));
            sb.append(parameterType.getSimpleName().substring(1));
            sb.append(", ");

        }
        if (method.getParameterTypes().length != 0) {
            sb.delete(sb.length()-2, sb.length());
        }
        sb.append(")");
        System.out.println(sb);
    }
}
