package com.mygroup.springlearning.chapter4.example3.standardFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageDigesterJavaConfig {
    @Bean
    public MessageDigestFactoryBean defaultDigest() {
        return new MessageDigestFactoryBean();
    }
    @Bean
    public MessageDigestFactoryBean shaDigest() {
        MessageDigestFactoryBean factoryBean = new MessageDigestFactoryBean();
        factoryBean.setAlgorithmName("SHA1");
        return factoryBean;
    }
    @Bean
    public MessageDigester digester() throws Exception {
        MessageDigester messageDigester = new MessageDigester();
        messageDigester.setDigest1(shaDigest().getObject());
        messageDigester.setDigest2(defaultDigest().getObject());
        return messageDigester;
    }
}
