package com.mygroup.springlearning.chapter4.example7;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Ch4Ex5XmlMain {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        Как аналог: указать в VMOptions: -Dspring.profiles.active=kindergarten
        ctx.getEnvironment().setActiveProfiles("highschool");//or kindergarten
        ctx.load("classpath:spring/chapter4/ch4ex7-profiles/*-config.xml");
        ctx.refresh();

        FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        lunchSet.forEach(System.out::println);

    }
}
