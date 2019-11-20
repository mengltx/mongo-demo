package com.pose.mongodemo;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.pose.mongodemo.entity.Order;
import com.pose.mongodemo.entity.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.Field;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);
    public static void main(String[] args) {

        MongoOperations operations = new MongoTemplate(MongoClients.create(new ConnectionString("mongodb://172.18.20.35:27011,172.18.20.35:27012,172.18.20.35:27013/usp?replcaSet=rs0&slaveOk=true&readPreference=primary")),"usp");

        //operations.insert(new Person("Joe",34));


        /*for(int i=11374;i<1000000;i++){
            operations.insert(new Person((int)Math.floor(Math.random()*120),"user"+i),"person");
        }*/

        /*List<Person> list = new ArrayList<>();
        int m = 1;
        for(int i =0;i<100;i++){

            for(int j=0;j<10000;j++){

                list.add(new Person((int)Math.floor(Math.random()*120),"user"+m));
                m++;
            }
            operations.insertAll(list);
            list.clear();
        }
*/
        //log.info(operations.findOne(new Query(),Person.class,"person"));

        //operations.dropCollection("person");


        Random random = new Random();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        long start = System.currentTimeMillis();
        for (int k = 0; k <10 ; k++) {
            int finalK = k;
            pool.execute(new Runnable() {
                @Override
                public void run() {

                    List<Order> list = new ArrayList<>();
                    int m = 1;
                    for(int i =0;i<10;i++){

                        for(int j=0;j<1000;j++){

                            list.add(new Order(finalK +"-order-"+m,random.nextInt(100)+10));
                            m++;
                        }
                        operations.insertAll(list);
                        list.clear();
                    }
                }
            });



        }

        pool.shutdown();

        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("执行时长"+(System.currentTimeMillis()-start));


    }
}
