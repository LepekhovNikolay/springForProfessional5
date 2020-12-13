package com.mygroup.springlearning.chapter4.example1.annotations;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Singer {
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

    @PostConstruct
    public void init() {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type" + Singer.class);
        }
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying bean" + count++);
    }
}


