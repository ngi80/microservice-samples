package com.todo.service.data.config;

import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nicolasgilmant on 8/03/16.
 */
@Configuration
public class MongoConfig {


    /**
     * Define an ACKNOWLEDGED strategy for WriteConcern.
     * allows clients to catch network, duplicate key, and other errors.
     *
     * @return mongodb WriteConcern
     */
    @Bean
    public WriteConcern writeConcern(){
        return WriteConcern.ACKNOWLEDGED;
    }
}
