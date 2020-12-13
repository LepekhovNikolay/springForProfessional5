package com.mygroup.springlearning.chapter3.example1.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class MessageProviderImpl implements MessageProvider {

    String message = "Hello world";

    public MessageProviderImpl() {
    }

//    Введение в конструктор значения "Configurable message"
//    @Autowired
//    public MessageProviderImpl(@Value("Configurable message") String message) {
//        this.message = message;
//    }

    public MessageProviderImpl(String message) {
        this.message = message;
    }

    @Autowired
    public MessageProviderImpl(@Value("90") int message) {
        this.message = "Вызван конструктор с int " + message;
    }

    public String getMessage() {
        return message;
    }
}
