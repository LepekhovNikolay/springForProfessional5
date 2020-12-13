package com.mygroup.springlearning.chapter4.example6;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Создание события и обработка в листенере возникновения события
 */
public class Publisher implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publish(String message) {
        ctx.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:spring/chapter4/ch4ex6-app-context.xml");
        Publisher publisher = (Publisher) ctx.getBean("publisher");
        publisher.publish("I send as SOS to the world...");
        publisher.publish("... I hope that someone gets my...");
        publisher.publish("... Message in a bottle");

    }
}
