package com.wso2telco.promotionalapp.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.wso2telco.promotionalapp.managed.DatabaseManaged;
import com.wso2telco.promotionalapp.model.application.Application;
import com.wso2telco.promotionalapp.model.application.ReceiverList;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;

import java.util.List;

/**
 * Created by dinindu on 6/11/17.
 */
public class DatabaseDAOImplementation implements IDatabaseDAO {

    private final DB db;
    private final MongoClient mongoClient;
    private final JacksonDBCollection<Application, String> applicationCollection;

    public DatabaseDAOImplementation(DatabaseManaged databaseManaged) {
        this.db = databaseManaged.getDb();
        this.mongoClient = databaseManaged.getMongoClient();
        this.applicationCollection = JacksonDBCollection.wrap(db.getCollection("application"),Application.class,String.class);
    }

    public Application getApplicationByAppId(String appId) {
        Application application = applicationCollection.findOne(DBQuery.is("appId",appId));
        return application;
    }

    @Override
    public List<ReceiverList> getReceiverListByAppId(String appId) {
        Application application = applicationCollection.findOne(DBQuery.is("appId",appId));
        return application.getAppConfig().getReceiverList();
    }
}
