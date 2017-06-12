package com.wso2telco.promotionalapp.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by dinindu on 5/29/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "message"
})
public class OutboundSMSTextMessage {

    /*public OutboundSMSTextMessage(String message){
        this.message = message;
    }*/

    @JsonProperty("message")
    private String message;

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

}
