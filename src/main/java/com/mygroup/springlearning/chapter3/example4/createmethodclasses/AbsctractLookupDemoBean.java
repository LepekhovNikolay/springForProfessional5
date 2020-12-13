package com.mygroup.springlearning.chapter3.example4.createmethodclasses;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLookupBean")
public abstract class AbsctractLookupDemoBean implements DemoBean{


    @Override
    @Lookup("singer")
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().song();
    }
}
