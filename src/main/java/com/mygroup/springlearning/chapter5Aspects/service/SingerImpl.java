package com.mygroup.springlearning.chapter5Aspects.service;

import com.mygroup.springlearning.chapter4.example1.impl.Ch4Ex1Main2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SingerImpl implements Singer, InitializingBean, DisposableBean {
    private  static final String DEFAULT_NAME = "Eric Clapton";
    private static int count;

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void sing() {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type" + com.mygroup.springlearning.chapter4.example1.init_method.Singer.class);
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy bean" + count++);
    }
}

