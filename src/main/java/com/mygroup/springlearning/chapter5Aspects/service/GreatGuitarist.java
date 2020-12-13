package com.mygroup.springlearning.chapter5Aspects.service;

public class GreatGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("I shot the sheriff," + System.lineSeparator() +
                "But I did not shoot the deputy");
    }
}
