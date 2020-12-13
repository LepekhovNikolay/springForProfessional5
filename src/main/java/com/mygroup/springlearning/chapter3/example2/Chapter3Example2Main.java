package com.mygroup.springlearning.chapter3.example2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;


/**
 * Пример класса с конфигурацией Спринг в xml
 * Установка внутренних полей напрямую через аннотации и объявление в конфигурационном файле xml
 */
@Service("injectSimple")
public class Chapter3Example2Main {

    @Value("John Mayer")
//    @Value("#{fromInject.name}")
    private String name;

    @Value("39")
    private int age;
    @Value("1.92")
    private float height;
    @Value("true")
    private boolean programmer;
    @Value("12444011")
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/chapter3/ch3ex2-app-context.xml");
        ctx.refresh();
        Chapter3Example2Main simple = (Chapter3Example2Main) ctx.getBean("injectSimple");
        System.out.println(simple);
        ctx.close();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", isProgrammer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
