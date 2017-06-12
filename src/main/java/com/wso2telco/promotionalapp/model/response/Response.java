
package com.wso2telco.promotionalapp.model.response;

/**
 * Created by dinindu on 5/30/17.
 */

import com.wso2telco.promotionalapp.model.request.OutboundSMSMessageRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "outboundSMSMessageRequest"
})
public class Response {

    @JsonProperty("outboundSMSMessageRequest")
    private OutboundSMSMessageRequest outboundSMSMessageRequest;

    @JsonProperty("outboundSMSMessageRequest")
    public OutboundSMSMessageRequest getOutboundSMSMessageRequest() {
        return outboundSMSMessageRequest;
    }

    @JsonProperty("outboundSMSMessageRequest")
    public void setOutboundSMSMessageRequest(OutboundSMSMessageRequest outboundSMSMessageRequest) {
        this.outboundSMSMessageRequest = outboundSMSMessageRequest;
    }

}
