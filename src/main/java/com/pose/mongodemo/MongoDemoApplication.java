package com.pose.mongodemo;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDemoApplication {

    @Autowired
    private Mongo mongo;

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

}
