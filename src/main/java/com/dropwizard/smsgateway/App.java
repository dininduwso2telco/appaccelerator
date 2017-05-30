package com.dropwizard.smsgateway;

import com.dropwizard.smsgateway.resources.SMSGatewayResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dinindu on 5/29/17.
 */
public class App extends Application<AppConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);


    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> b) {}

    public void run(AppConfiguration configuration, Environment environment) throws Exception {

        LOGGER.info("Method SMSApplication#run() called");

        environment.jersey().register(new SMSGatewayResource(configuration));
    }
}
