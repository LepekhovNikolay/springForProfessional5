package com.mygroup.springlearning.chapter4.example7;

public class Food {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food: " + name;
    }
}
