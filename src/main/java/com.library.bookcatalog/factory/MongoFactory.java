package com.library.bookcatalog.factory;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoFactory {
    private static final Logger logger = LoggerFactory.getLogger(MongoFactory.class);

    private static MongoClient mongoClient;

    public @Bean
    static MongoClient getMongo() {
        int port_no = 27017;
        String hostname = "localhost";
        if (mongoClient == null) {
            try {
                mongoClient = new MongoClient(hostname, port_no);
            } catch (MongoException ex) {
                logger.error(String.valueOf(ex));
            }
        }
        return mongoClient;
    }
}
