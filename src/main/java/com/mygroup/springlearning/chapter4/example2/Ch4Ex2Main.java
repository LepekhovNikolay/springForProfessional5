package com.mygroup.springlearning.chapter4.example2;

import org.springframework.context.support.GenericXmlApplicationContext;


/**
 * Передача бину его имени и контекста
 */
public class Ch4Ex2Main {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/chapter4/ch4ex2-app-context.xml");
        ctx.refresh();
        NamedSinger bean = (NamedSinger)ctx.getBean("johnMayer");
        bean.sing();
    }

}
