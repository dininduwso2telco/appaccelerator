package com.wso2telco.promotionalapp;

import com.mongodb.MongoClient;
import com.wso2telco.promotionalapp.configurations.PromotionalAppConfiguration;
import com.wso2telco.promotionalapp.handlers.PromotionalAppHandler;
import com.wso2telco.promotionalapp.managed.DatabaseManaged;
import com.wso2telco.promotionalapp.resources.PromotionalAppResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dinindu on 5/29/17.
 */
public class PromotionalApp extends Application<PromotionalAppConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PromotionalApp.class);


    public static void main( String[] args ) throws Exception
    {
        new PromotionalApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<PromotionalAppConfiguration> b) {}

    public void run(PromotionalAppConfiguration configuration, Environment environment) throws Exception {

        LOGGER.info("Method PromotionalApp#run() called");

        MongoClient mongoClient = new MongoClient(configuration.getMongo().getHost(),
                configuration.getMongo().getPort());
        DatabaseManaged databaseManaged = new DatabaseManaged(mongoClient,configuration.getMongo());
        environment.lifecycle().manage(databaseManaged);

        PromotionalAppHandler promotionalAppHandler = new PromotionalAppHandler(configuration,databaseManaged);
        environment.jersey().register(new PromotionalAppResource(promotionalAppHandler));
    }
}
