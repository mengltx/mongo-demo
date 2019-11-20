package com.pose.mongodemo.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

@Configuration
public class AppConfig {

    @Bean
    public MongoClient mongoClient(){
        return new MongoClient("120.55.62.68",27011);
    }

    @Bean
    public MongoClientFactoryBean mongo(){
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("120.55.62.68");
        mongo.setPort(27011);
        return mongo;
    }
}
