package com.dropwizard.smsgateway.smssender;

/**
 * Created by dinindu on 5/29/17.
 */
public class SMSRequestConfiguration {

    public OutboundSMSMessageRequest getOutboundSMSMessageRequest() {
        return outboundSMSMessageRequest;
    }

    public void setOutboundSMSMessageRequest(OutboundSMSMessageRequest outboundSMSMessageRequest) {
        this.outboundSMSMessageRequest = outboundSMSMessageRequest;
    }

    private OutboundSMSMessageRequest outboundSMSMessageRequest;




}
