package com.mygroup.springlearning.chapter3.example5;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;


/**
 * Изменение метода через конфигурационный файл
 */
public class Chapter3Example5Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/chapter3/ch3ex5-app-context.xml");
        ctx.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage(getRandomString()));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        int counts = 1_000_000;
        for (int i = 0; i < counts; i++) {
            String out = target.formatMessage(getRandomString());
        }
        stopWatch.stop();
        System.out.println(counts + " invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }

    private static String getRandomString() {
       return Double.toString(Math.random());
    }
}
