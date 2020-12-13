package com.mygroup.springlearning.chapter4.example5.customJava;

import com.mygroup.springlearning.chapter4.example5.customJava.message.MessageProvider2;
import com.mygroup.springlearning.chapter4.example5.customJava.message.MessageProviderImpl2;
import com.mygroup.springlearning.chapter4.example5.customJava.message.MessageRenderer2;
import com.mygroup.springlearning.chapter4.example5.customJava.message.MessageRendererImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:properties/message.properties")
public class AppConfigOne {

    @Autowired
    Environment env;

    @Bean
    @Lazy
    public MessageProvider2 messageProvider2() {
        return new MessageProviderImpl2(
                env.getProperty("message")
        );
    }

    @Bean(name = "messageRenderer2")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider2")
    public MessageRenderer2 messageRenderer2() {
        MessageRenderer2 renderer = new MessageRendererImpl2();
        renderer.setMessageProvider(messageProvider2());
        return renderer;
    }
}
