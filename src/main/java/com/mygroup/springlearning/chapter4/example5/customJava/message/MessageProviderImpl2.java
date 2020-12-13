package com.mygroup.springlearning.chapter4.example5.customJava.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class MessageProviderImpl2 implements MessageProvider2 {

    String message = "Hello world";

    public MessageProviderImpl2() {
    }

//    Введение в конструктор значения "Configurable message"
//    @Autowired
//    public MessageProviderImpl(@Value("Configurable message") String message) {
//        this.message = message;
//    }

    public MessageProviderImpl2(String message) {
        this.message = message;
    }

    @Autowired
    public MessageProviderImpl2(@Value("90") int message) {
        this.message = "Вызван конструктор с int " + message;
    }

    public String getMessage() {
        return message;
    }
}
