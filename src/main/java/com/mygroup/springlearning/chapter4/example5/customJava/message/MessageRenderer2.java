package com.mygroup.springlearning.chapter4.example5.customJava.message;

public interface MessageRenderer2 {
    void render();
    void setMessageProvider(MessageProvider2 provider);
    MessageProvider2 getMessageProvider();
}
