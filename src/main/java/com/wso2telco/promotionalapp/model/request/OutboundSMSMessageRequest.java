package com.wso2telco.promotionalapp.model.request;

import com.wso2telco.promotionalapp.model.response.DeliveryInfoList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by dinindu on 5/29/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)

public class OutboundSMSMessageRequest {

    @JsonProperty
    private List<String> address;

    @JsonProperty
    private String senderAddress;

    @JsonProperty
    private OutboundSMSTextMessage outboundSMSTextMessage;

    @JsonProperty
    private String clientCorrelator;

    @JsonProperty
    private String senderName;

    @JsonProperty
    private ReceiptRequest receiptRequest;

    @JsonProperty
    private DeliveryInfoList deliveryInfoList;

    @JsonProperty("resourceURL")
    private String resourceURL;


    @JsonProperty("address")
    public List<String> getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(List<String> address) {
        this.address = address;
    }

    @JsonProperty("outboundSMSTextMessage")
    public OutboundSMSTextMessage getOutboundSMSTextMessage() {
        return outboundSMSTextMessage;
    }

    @JsonProperty("outboundSMSTextMessage")
    public void setOutboundSMSTextMessage(OutboundSMSTextMessage outboundSMSTextMessage) {
        this.outboundSMSTextMessage = outboundSMSTextMessage;
    }

    @JsonProperty("clientCorrelator")
    public String getClientCorrelator() {
        return clientCorrelator;
    }

    @JsonProperty("clientCorrelator")
    public void setClientCorrelator(String clientCorrelator) {
        this.clientCorrelator = clientCorrelator;
    }

    @JsonProperty("receiptRequest")
    public ReceiptRequest getReceiptRequest() {
        return receiptRequest;
    }

    @JsonProperty("receiptRequest")
    public void setReceiptRequest(ReceiptRequest receiptRequest) {
        this.receiptRequest = receiptRequest;
    }

    @JsonProperty("deliveryInfoList")
    public DeliveryInfoList getDeliveryInfoList() {
        return deliveryInfoList;
    }

    @JsonProperty("deliveryInfoList")
    public void setDeliveryInfoList(DeliveryInfoList deliveryInfoList) {
        this.deliveryInfoList = deliveryInfoList;
    }

    @JsonProperty("senderAddress")
    public String getSenderAddress() {
        return senderAddress;
    }

    @JsonProperty("senderAddress")
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    @JsonProperty("senderName")
    public String getSenderName() {
        return senderName;
    }

    @JsonProperty("senderName")
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @JsonProperty("resourceURL")
    public String getResourceURL() {
        return resourceURL;
    }

    @JsonProperty("resourceURL")
    public void setResourceURL(String resourceURL) {
        this.resourceURL = resourceURL;
    }

}
