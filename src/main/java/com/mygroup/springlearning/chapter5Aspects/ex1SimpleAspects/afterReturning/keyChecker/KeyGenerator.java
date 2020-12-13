package com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.afterReturning.keyChecker;

import java.util.Random;

public class KeyGenerator {
    protected  static final long WEAK_KEY =   0xFFFFFFF00000000L;
    protected  static final long STRONG_KEY = 0xACDF03F5390AE56L;
    private Random rand = new Random();

    public long getKey() {
        int x = rand.nextInt(3);
        if (x == 1) {
            return WEAK_KEY;
        }
        return STRONG_KEY;
    }
}
