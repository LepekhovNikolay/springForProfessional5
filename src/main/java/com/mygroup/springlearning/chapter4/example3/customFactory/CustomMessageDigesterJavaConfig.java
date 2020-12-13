package com.mygroup.springlearning.chapter4.example3.customFactory;

import com.mygroup.springlearning.chapter4.example3.standardFactory.MessageDigester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;

@Configuration
public class CustomMessageDigesterJavaConfig {
    @Bean
    public MessageDigestFactory shaDigestFactory() {
        MessageDigestFactory factory = new MessageDigestFactory();
        factory.setAlgorithmName("SHA1");
        return factory;
    }

    @Bean
    public MessageDigestFactory defaultDigestFactory() {
        return new MessageDigestFactory();
    }

    @Bean
    public MessageDigest shaDigest() throws Exception{
        return shaDigestFactory().createInstance();
    }

    @Bean
    public MessageDigest defaultDigest() throws Exception{
        return defaultDigestFactory().createInstance();
    }

    @Bean
    public MessageDigester digester() throws Exception {
        MessageDigester messageDigester = new MessageDigester();
        messageDigester.setDigest1(shaDigest());
        messageDigester.setDigest2(defaultDigest());
        return messageDigester;
    }
}
