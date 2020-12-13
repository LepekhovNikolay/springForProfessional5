package com.mygroup.springlearning.chapter3.example5;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FormatMessageReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        if (isFormatMessageMethod(method)) {
            String message = (String) objects[0];
            return String.format("<h2>%s</h2>", message);
        } else {
            throw new IllegalArgumentException("Unable to reimplement method" + method.getName());
        }

    }

    private boolean isFormatMessageMethod(Method method) {
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        if (!("formatMessage".equals(method.getName()))) {
            return false;
        }
        if (method.getReturnType() != String.class) {
            return false;
        }
        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }
        return true;
    }
}