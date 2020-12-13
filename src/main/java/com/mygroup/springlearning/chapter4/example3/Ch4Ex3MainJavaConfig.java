package com.mygroup.springlearning.chapter4.example3;

import com.mygroup.springlearning.chapter4.example3.customFactory.CustomMessageDigesterJavaConfig;
import com.mygroup.springlearning.chapter4.example3.standardFactory.MessageDigester;
import com.mygroup.springlearning.chapter4.example3.standardFactory.MessageDigesterJavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Ch4Ex3MainJavaConfig {

    public static void main(String[] args) {
//        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(MessageDigesterJavaConfig.class);
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(CustomMessageDigesterJavaConfig.class);
        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello world!");
        ctx.registerShutdownHook();
    }

}
