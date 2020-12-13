package com.mygroup.springlearning.chapter3.example1;

import com.mygroup.springlearning.chapter3.example1.message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/**
 * Пример класса с конфигурацией Спринг в xml и java
 * Установка внутренних полей через setters и constructor через аннотации и объявление в конфигурационных файлах xml и java
 */
public class Chapter3Example1Main {

    public static void main(String[] args) {
        //context by GenericXml - можно несколько путей загружать
/*        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/chapter3/ch3ex1-app-context.xml");
        ctx.refresh();*/


        //конфигурация через java
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Example1Configuration.class);

        MessageRenderer messageRenderer = ctx.getBean("myRenderer", MessageRenderer.class);
        messageRenderer.render();

//        закрытие контектса только для Generic
/*        ctx.close();*/
    }
}


