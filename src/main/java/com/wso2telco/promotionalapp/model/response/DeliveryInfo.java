
package com.wso2telco.promotionalapp.model.response;

/**
 * Created by dinindu on 5/30/17.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "deliveryStatus"
})
public class DeliveryInfo {

    @JsonProperty("address")
    private String address;
    @JsonProperty("deliveryStatus")
    private String deliveryStatus;

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("deliveryStatus")
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    @JsonProperty("deliveryStatus")
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

}
