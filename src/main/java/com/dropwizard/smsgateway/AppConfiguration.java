package com.dropwizard.smsgateway;

import com.dropwizard.smsgateway.smssender.SMSRequestConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by dinindu on 5/29/17.
 */
public class AppConfiguration extends Configuration {


    @JsonProperty
    private String smsgateway;

    private SMSRequestConfiguration smsrequest;


    public SMSRequestConfiguration getSmsrequest() {
        return smsrequest;
    }

    public void setSmsrequest(SMSRequestConfiguration smsrequest) {
        this.smsrequest = smsrequest;
    }

    public String getSmsgateway() {
        return smsgateway;
    }

    public void setSmsgateway(String smsgateway) {
        this.smsgateway = smsgateway;
    }

}
