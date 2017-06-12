package com.wso2telco.promotionalapp.managed;

/**
 * Created by dinindu on 6/6/17.
 */

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.wso2telco.promotionalapp.configurations.DatabaseConfiguration;
import io.dropwizard.lifecycle.Managed;

public class DatabaseManaged implements Managed {

    private MongoClient mongoClient;

    private DB db;

    public DatabaseManaged(MongoClient mongoClient, DatabaseConfiguration mongoConfigurations) {
        this.mongoClient = mongoClient;
        this.db = mongoClient.getDB(mongoConfigurations.getDb());
    }

    public void start() throws Exception {
    }

    public void stop() throws Exception {
        mongoClient.close();
    }

    public DB getDb() {
        return db;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
