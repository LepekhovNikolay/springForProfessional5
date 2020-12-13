package com.mygroup.springlearning.chapter5Aspects.ex2Pointcuts.staticMethodMatcher.comparison;

public class DefaultSimpleBean implements SimpleBean {
    private long dummy = 0;

    @Override
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    @Override
    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
}
