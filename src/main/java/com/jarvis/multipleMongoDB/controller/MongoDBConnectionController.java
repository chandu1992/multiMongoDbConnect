package com.jarvis.multipleMongoDB.controller;

import com.jarvis.multipleMongoDB.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("api/v1/")
public class MongoDBConnectionController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    @Qualifier("mongoTemplateSecond")
    MongoTemplate mongoTemplateSecond;

    @Autowired
    @Qualifier("mongoTemplateThird")
    MongoTemplate mongoTemplateThird;

    @GetMapping("/getMongoTemplate")
    public String getMongoTemplate(@RequestBody User user){
        System.out.println(mongoTemplate);
                mongoTemplate.save(user);
        return "Connected to database: " + mongoTemplate.getDb().getName();
    }

    @GetMapping("/getMongoTemplateSecond")
    public String getMongoTemplateSecond(@RequestBody User user){
        System.out.println(mongoTemplateSecond);
        mongoTemplateSecond.save(user);
        return "Connected to database: " + mongoTemplateSecond.getDb().getName();
    }

    @GetMapping("/getMongoTemplateThird")
    public String getMongoTemplateThird(@RequestBody User user){
        System.out.println(mongoTemplateThird);
        mongoTemplateThird.save(user);
        return "Connected to database: " + mongoTemplateThird.getDb().getName();
    }

    @GetMapping("/getData")
    public Set<String> getData(){
        Set<String> data = mongoTemplateThird.getCollectionNames();
        return  data;
    }
}
