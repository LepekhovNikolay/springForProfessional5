package com.mygroup.springlearning.chapter3.example4.createmethodclasses;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standardLookupBean")
public class StandardLookupDemoBean implements DemoBean{
    private Singer mySinger;

    public StandardLookupDemoBean(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    @Qualifier("singer")
    public Singer getMySinger() {
        return this.mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.song();
    }
}
