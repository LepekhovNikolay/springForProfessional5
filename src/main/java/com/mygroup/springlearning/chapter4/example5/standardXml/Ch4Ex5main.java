package com.mygroup.springlearning.chapter4.example5.standardXml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

/**
 * Исопльзование property reader
 */
public class Ch4Ex5main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/chapter4/ch4ex5-app-context.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, german));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayer"}, english));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayer"}, german));
        ctx.registerShutdownHook();
    }
}
