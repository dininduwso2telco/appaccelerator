package com.wso2telco.promotionalapp.configurations;

import com.wso2telco.promotionalapp.model.request.SMSRequestConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by dinindu on 5/29/17.
 */
public class PromotionalAppConfiguration extends Configuration {


    @JsonProperty
    private String smsgateway;

    @JsonProperty
    private String appId;

    @Valid
    @NotNull
    private DatabaseConfiguration mongo = new DatabaseConfiguration();


    public DatabaseConfiguration getMongo() {
        return mongo;
    }

    public void setMongo(DatabaseConfiguration mongo) {
        this.mongo = mongo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSmsgateway() {
        return smsgateway;
    }

    public void setSmsgateway(String smsgateway) {
        this.smsgateway = smsgateway;
    }

}
