package com.mygroup.springlearning.chapter3.example5;

import java.text.MessageFormat;

public class ReplacementTarget {
    public String formatMessage(String message) {
//        return "<h1>" + message +"</h1>";
        return String.format("<h1>%s</h1>", message);
//        return MessageFormat.format("<h1>{0}}</h1>", message);
    }

    public String formatMessage(Object message) {
        return formatMessage(message.toString());
    }
}
