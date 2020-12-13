package com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.methodBefore.security;

public class SecureBean {
    public void writeSecureMessage() {
        System.out.println("Every time I learn something new, " +
                "it pushes some old stuff out of my brain");
    }
}
