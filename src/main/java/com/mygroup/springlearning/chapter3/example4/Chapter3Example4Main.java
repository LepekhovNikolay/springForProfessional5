package com.mygroup.springlearning.chapter3.example4;

import com.mygroup.springlearning.chapter3.example4.createmethodclasses.DemoBean;
import com.mygroup.springlearning.chapter3.example4.createmethodclasses.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * создание геттера и внедрение бина со скопом prototype
 */
public class Chapter3Example4Main {

    private static final Stage PRINT_INFO_STAGES = Stage.AFTER_EXECUTION;
    private static final boolean SINGER_IS_SONG = false;
    private static final int REPEATS = 100_000;


    private enum Stage {
        AFTER_EXECUTION, AT_RUNTIME
    }

    @Configuration
    @ComponentScan(basePackages = "com.mygroup.springlearning.chapter3.example4.createmethodclasses")
    public static class LookupConfig {}

    public static void main(String[] args) {

//        Конфигурация через XML
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:spring/chapter3/ch3ex4-app-context.xml");
//        ctx.refresh();

        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(LookupConfig.class);

        DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean", DemoBean.class);
        DemoBean standardBean = (DemoBean) ctx.getBean("standardLookupBean", DemoBean.class);
        List<List<Object>> results = new ArrayList<>();
        results.add(displayInfo(
                standardBean.getClass().getSimpleName().replaceAll("\\$.*",""),
                abstractBean));
        results.add(displayInfo(
                standardBean.getClass().getSimpleName().replaceAll("\\$.*",""),
                standardBean));
        if (PRINT_INFO_STAGES == Stage.AFTER_EXECUTION) {
            results.forEach(result -> {
                printResults((Long)result.get(0),
                        (Boolean) result.get(1),
                        (String) result.get(2));
            });
        }
//        ctx.close();

    }

    /**
     *
     * @param beanName
     * @param bean
     * @return List of Object .
     * get(0) - time in ms, type: long.
     * get(1) - same objects? type - boolean,
     * get(2) - beanName type - String
     * только после написания этой дичи, у меня случилось озарение, что нужно было просто передавать в метод stringbuilder:)
     */
    private static List<Object> displayInfo(String beanName, DemoBean bean) {
        Singer singer1 = bean.getMySinger();
        Singer singer2 = bean.getMySinger();
        boolean isEqual = singer1 == singer2;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int i = 0; i < REPEATS; i++) {
            Singer singer = bean.getMySinger();
            if (SINGER_IS_SONG) {
                singer.song();
            }
        }
        stopWatch.stop();
        if (PRINT_INFO_STAGES == Stage.AT_RUNTIME) {
            printResults(stopWatch.getTotalTimeMillis(), isEqual, beanName);
        }
        List<Object> result = Arrays.asList(stopWatch.getTotalTimeMillis(), isEqual, beanName);
        return  result;
    }

    private static void printResults(long ms, boolean isEqual, String beanName){
        System.out.println(beanName + ": " + "Singer instances the same?:" + isEqual);
        System.out.println(REPEATS +" gets took " + ms + " ms");
    }
}
