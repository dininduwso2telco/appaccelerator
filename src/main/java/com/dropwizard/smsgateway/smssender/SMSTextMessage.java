package com.dropwizard.smsgateway.smssender;

/**
 * Created by dinindu on 5/29/17.
 */
public class SMSTextMessage {

    public SMSTextMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
