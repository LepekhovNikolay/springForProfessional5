package com.mygroup.springlearning.chapter4.example5.customJava;

import com.mygroup.springlearning.chapter4.example5.customJava.message.MessageRenderer2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Ch4Ex5Main {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigOne.class);
        MessageRenderer2 messageRenderer = (MessageRenderer2) ctx.getBean("messageRenderer2");
        messageRenderer.render();
    }
}
