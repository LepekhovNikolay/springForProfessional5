package com.mygroup.springlearning.chapter5Aspects.ex1SimpleAspects.methodInterceptor;

import com.mygroup.springlearning.chapter5Aspects.service.Helper;

public class ProfilingDemo {
    public static void main(String[] args) {
        WorkerBean bean = Helper.getProxy(new WorkerBean(), new ProfilingInterceptor());
        bean.doSomeWork(1_000_000);
    }
}
