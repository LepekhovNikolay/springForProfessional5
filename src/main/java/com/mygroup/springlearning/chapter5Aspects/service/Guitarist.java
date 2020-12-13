package com.mygroup.springlearning.chapter5Aspects.service;

import com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.annotationMatching.AdviceRequired;

public class Guitarist implements Singer {

    private String lyric="You're gonna live forever in me";

    @AdviceRequired
    @Override
    public void sing() {
        System.out.println(lyric);
    }

    public void sing2() {
        System.out.println("Oh gravity, stay the hell away from me");
    }

    public void rest() {
        System.out.println("zzz");
    }
}
