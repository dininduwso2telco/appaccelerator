package com.dropwizard.smsgateway.smssender;

/**
 * Created by dinindu on 5/29/17.
 */
public class SMSReceiptRequest {

    private String notifyURL;
    private String callbackData;

    public String getNotifyURL() {
        return notifyURL;
    }

    public void setNotifyURL(String notifyURL) {
        this.notifyURL = notifyURL;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

}
