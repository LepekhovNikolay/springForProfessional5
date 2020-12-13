package com.mygroup.springlearning.chapter3.example6;

public class Singer {
    private String name;
    private int age;

    public Singer() {
    }

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
}
