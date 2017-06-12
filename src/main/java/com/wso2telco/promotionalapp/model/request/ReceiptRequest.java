package com.wso2telco.promotionalapp.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by dinindu on 5/29/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "notifyURL",
        "callbackData"
})
public class ReceiptRequest {

    @JsonProperty("notifyURL")
    private String notifyURL;
    @JsonProperty("callbackData")
    private String callbackData;

    @JsonProperty("notifyURL")
    public String getNotifyURL() {
        return notifyURL;
    }

    @JsonProperty("notifyURL")
    public void setNotifyURL(String notifyURL) {
        this.notifyURL = notifyURL;
    }

    @JsonProperty("callbackData")
    public String getCallbackData() {
        return callbackData;
    }

    @JsonProperty("callbackData")
    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

}
