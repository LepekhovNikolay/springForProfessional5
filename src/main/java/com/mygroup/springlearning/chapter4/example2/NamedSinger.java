package com.mygroup.springlearning.chapter4.example2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class NamedSinger implements BeanNameAware, ApplicationContextAware {

    private String beanName;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        if (ctx instanceof GenericApplicationContext) {
            ((GenericApplicationContext) ctx).registerShutdownHook();
        }
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName =  beanName;
    }

    public void sing() {
        System.out.println("Singer " + beanName + " sing()");
    }
}
