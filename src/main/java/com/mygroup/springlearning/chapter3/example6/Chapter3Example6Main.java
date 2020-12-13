package com.mygroup.springlearning.chapter3.example6;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Создание базового бина для того, чтобы не нужно было инициализировать все поля
 */
public class Chapter3Example6Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/chapter3/ch3ex6-app-context.xml");
        ctx.refresh();
        Singer parent = (Singer) ctx.getBean("parent");
        Singer child = (Singer) ctx.getBean("child");
        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }
}
