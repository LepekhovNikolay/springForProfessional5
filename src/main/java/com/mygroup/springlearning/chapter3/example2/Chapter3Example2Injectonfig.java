package com.mygroup.springlearning.chapter3.example2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("fromInject")
public class Chapter3Example2Injectonfig {

    private String name = "John Mayer";
    private int age = 39;
    private float height = 1.92f;
    private boolean programmer = true;
    private Long ageInSeconds = 1_241_401_112L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
}
