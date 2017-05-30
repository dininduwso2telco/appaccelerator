package com.dropwizard.smsgateway.smssender;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.jvnet.hk2.annotations.Optional;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by dinindu on 5/29/17.
 */
public class OutboundSMSMessageRequest {

    @JsonProperty
    @NotNull
    private List<String> address;

    @JsonProperty
    @Optional
    private String senderAddress;

    @JsonProperty
    private SMSTextMessage outboundSMSTextMessage;

    @JsonProperty
    private String clientCorrelator;

    @JsonProperty
    private String senderName;

    @JsonProperty
    private SMSReceiptRequest receiptRequest;


    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public SMSTextMessage getOutboundSMSTextMessage() {
        return outboundSMSTextMessage;
    }

    public void setOutboundSMSTextMessage(SMSTextMessage outboundSMSTextMessage) {
        this.outboundSMSTextMessage = outboundSMSTextMessage;
    }

    public String getClientCorrelator() {
        return clientCorrelator;
    }

    public void setClientCorrelator(String clientCorrelator) {
        this.clientCorrelator = clientCorrelator;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public SMSReceiptRequest getReceiptRequest() {
        return receiptRequest;
    }

    public void setReceiptRequest(SMSReceiptRequest receiptRequest) {
        this.receiptRequest = receiptRequest;
    }
}
