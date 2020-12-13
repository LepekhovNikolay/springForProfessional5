package com.mygroup.springlearning.chapter4.example5.customJava.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service("renderer")
public class MessageRendererImpl2 implements MessageRenderer2 {
    private MessageProvider2 messageProvider;

    public MessageRendererImpl2() {
    }

    public MessageRendererImpl2(MessageProvider2 provider) {
        this.messageProvider = provider;
    }

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    MessageFormat.format("You must set the property messageProvider of class:{0}",
                            MessageRendererImpl2.class.getName()));
        }
        System.out.println(messageProvider.getMessage());
    }
    @Autowired
    //равнозначно @Autowired, требуется javax.inject.javax.inject.1 зависимость
//    @Inject
    public void setMessageProvider(MessageProvider2 provider) {
        this.messageProvider = provider;
    }

    public MessageProvider2 getMessageProvider() {
        return this.messageProvider;
    }
}
