package com.mygroup.springlearning.chapter3.example1;

import com.mygroup.springlearning.chapter3.example1.message.MessageProvider;
import com.mygroup.springlearning.chapter3.example1.message.MessageProviderImpl;
import com.mygroup.springlearning.chapter3.example1.message.MessageRenderer;
import com.mygroup.springlearning.chapter3.example1.message.MessageRendererImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//загрузка конфигурации из xml:
//@ImportResource(locations = ("classpath:spring/app-context.xml"))

//поиск бинов по пути, требуются аннотации в самих классах
//@ComponentScan(basePackages = {"com.mygroup.springlearning.chapter3.example1.message"})
//@Configuration
public class Example1Configuration {
   // аннотация каждого бина
     @Bean(name = {"provider", "myProvider"})
    public MessageProvider provider() {
        return new MessageProviderImpl();
    }

    @Bean(name = {"renderer", "myRenderer"})
    public MessageRenderer renderer() {
        MessageRenderer renderer = new MessageRendererImpl();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
