package com.todo.service;

import com.todo.service.data.config.MongoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.MongoDbFactory;

/**
 * Created by nicolasgilmant on 13/04/16.
 */
@SpringBootApplication
@Configuration
@Import({
        MongoConfig.class})
public class Application
{
    @Autowired
    private MongoDbFactory mongoDbFactory;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
