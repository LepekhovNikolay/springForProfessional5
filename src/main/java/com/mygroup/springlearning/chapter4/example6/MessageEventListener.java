package com.mygroup.springlearning.chapter4.example6;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        System.out.println("Received: " + messageEvent.getMessage());
    }
}
