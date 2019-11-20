package com.pose.mongodemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Data
@Document(collection = "z_order")
public class Order {

    @Id
    private String id;

    private String orderNumber;

    private Integer count;

    public Order(String orderNumber, Integer count) {
        this.orderNumber = orderNumber;
        this.count = count;
    }

    static  Random random = new Random();

    public static void main(String[] args) {
        random.ints(10,20);
    }
}
