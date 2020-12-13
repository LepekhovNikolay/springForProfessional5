package com.mygroup.springlearning.chapter4.example1.configByJava;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

public class JavaConfigMain {

    @Configuration
    static class Config {
        @Lazy
        @Bean(initMethod = "init", destroyMethod = "destroy")
        Singer singerOne() {
            Singer singer = new Singer();
            singer.setName("John Mayer");
            singer.setAge(39);
            return singer;
        }

        @Lazy
        @Bean(initMethod = "init", destroyMethod = "destroy")
        Singer singerTwo() {
            Singer singer = new Singer();
            singer.setAge(39);
            return singer;
        }

        @Lazy
        @Bean(initMethod = "init", destroyMethod = "destroy")
        Singer singerThree() {
            Singer singer = new Singer();
            singer.setName("John Mayer");
            return singer;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
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
