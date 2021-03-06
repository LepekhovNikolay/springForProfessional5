package com.mygroup.springlearning.chapter4.example1.annotations;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ch4Ex1Main3 {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/chapter4/ch4ex1_annotations-app-context.xml");
        ctx.refresh();
        printBean("singerOne", ctx);
        printBean("singerTwo", ctx);
        printBean("singerThree", ctx);

        ctx.registerShutdownHook();
    }

    private static void printBean(String beanName, ApplicationContext ctx) {
        try {
            Singer bean = (Singer) ctx.getBean(beanName);
            System.out.println(bean);
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: " + ex.getMessage());
        }
    }


}


