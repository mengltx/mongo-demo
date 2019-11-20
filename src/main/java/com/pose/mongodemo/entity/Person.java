package com.pose.mongodemo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "person")
public class Person {

    private String id;

    private Integer age;

    private String name;


    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}

