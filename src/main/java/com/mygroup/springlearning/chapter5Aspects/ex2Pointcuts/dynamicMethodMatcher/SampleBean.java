package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.dynamicMethodMatcher;

public class SampleBean {
    public void foo(int x) {
        System.out.println("Invoced foo() with: " + x);
    }

    public void bar() {
        System.out.println("Invoked bar()");
    }
}
