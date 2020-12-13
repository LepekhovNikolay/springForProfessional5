package com.mygroup.springlearning.chapter3.example1.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service("renderer")
public class MessageRendererImpl implements MessageRenderer {
    private MessageProvider messageProvider;

    public MessageRendererImpl() {
    }

    public MessageRendererImpl(MessageProvider provider) {
        this.messageProvider = provider;
    }

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    MessageFormat.format("You must set the property messageProvider of class:{0}",
                            MessageRendererImpl.class.getName()));
        }
        System.out.println(messageProvider.getMessage());
    }
    @Autowired
    //равнозначно @Autowired, требуется javax.inject.javax.inject.1 зависимость
//    @Inject
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
