package com.mygroup.springlearning.chapter4.example1.impl;

import com.mygroup.springlearning.chapter5Aspects.service.SingerImpl;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Ch4Ex1Main2 {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/chapter4/ch4ex1_impl-app-context.xml");
        ctx.refresh();
        printBean("singerOne", ctx);
        printBean("singerTwo", ctx);
        printBean("singerThree", ctx);

        ctx.close();
    }

    private static void printBean(String beanName, ApplicationContext ctx) {
        try {
            SingerImpl bean = (SingerImpl) ctx.getBean(beanName);
            System.out.println(bean);
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: " + ex.getMessage());
        }
    }

    public static class Singer {
        private  static final String DEFAULT_NAME = "Eric Clapton";
        private static int count;

        private String name;
        private int age = Integer.MIN_VALUE;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Singer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @PostConstruct
        public void init() {
            System.out.println("Initializing bean");

            if (name == null) {
                System.out.println("Using default name");
                name = DEFAULT_NAME;
            }

            if (age == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("You must set the age property of any beans of type" + com.mygroup.springlearning.chapter4.example1.annotations.Singer.class);
            }
        }

        @PreDestroy
        public void destroy() {
            System.out.println("Destroying bean" + count++);
        }

    }
}

