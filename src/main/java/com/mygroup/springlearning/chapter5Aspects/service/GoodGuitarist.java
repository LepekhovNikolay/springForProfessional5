package com.mygroup.springlearning.chapter5Aspects.service;

public class GoodGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Who says I can't be free" + System.lineSeparator() +
                "From all of the things that I used to be");
    }
}
