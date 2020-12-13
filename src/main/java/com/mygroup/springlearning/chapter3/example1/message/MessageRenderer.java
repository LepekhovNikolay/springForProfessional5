package com.mygroup.springlearning.chapter3.example1.message;

public interface MessageRenderer {
    void render();
    void setMessageProvider (MessageProvider provider);
    MessageProvider getMessageProvider();
}
