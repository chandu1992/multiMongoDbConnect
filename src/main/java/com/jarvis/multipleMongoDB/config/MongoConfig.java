package com.jarvis.multipleMongoDB.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.database}")
    String fistDB;

    @Value("${second.mongodb.database}")
    String secondDB;

    @Value("${third.mongodb.database}")
    String thirdDB;


    private static final String MONGO_URI = "mongodb://localhost:27017";

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(MONGO_URI);
    }

    @Primary
    @Bean(name="mongoTemplate")
    public MongoTemplate getFirstBean(){
        return new MongoTemplate(mongoClient(), fistDB);
    }

    @Bean(name="mongoTemplateSecond")
    public MongoTemplate getSecondBean(){
        return new MongoTemplate(mongoClient(), secondDB);
    }

    @Bean(name="mongoTemplateThird")
    public MongoTemplate getThirdBean(){
        return new MongoTemplate(mongoClient(), thirdDB);
    }
}
