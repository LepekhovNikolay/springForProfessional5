package com.mygroup.springlearning.chapter3.example4.createmethodclasses;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
@Scope("prototype")
public class Singer {
    private String lyric = "I played a quick game of chess";

    public void song() {
        System.out.println(lyric);
    }
}
