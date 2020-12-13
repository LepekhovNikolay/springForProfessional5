package com.mygroup.springlearning.chapter4.example5.standardJava;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class Ch4Ex5JavaMain {

    @Configuration
    public static class Ch4Ex5JavaConfiguration {
        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource source = new ResourceBundleMessageSource();
            source.setBasenames("resourcebundles/labels");
            return source;
        }
    }


    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(Ch4Ex5JavaConfiguration.class);
        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, german));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayer"}, english));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayer"}, german));
        ctx.registerShutdownHook();
    }
}
