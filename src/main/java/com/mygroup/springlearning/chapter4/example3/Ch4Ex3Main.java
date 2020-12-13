package com.mygroup.springlearning.chapter4.example3;

import com.mygroup.springlearning.chapter4.example3.standardFactory.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Использование стандартной и кастомной фабрик для получения бинов
 * Использование MessageDigest
 */
public class Ch4Ex3Main {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:spring/chapter4/ch4ex3-standardFactory-app-context.xml");
        ctx.load("classpath:spring/chapter4/ch4ex3-customFactory-app-context.xml");
        ctx.refresh();
        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello world!");
        ctx.registerShutdownHook();

    }
}
