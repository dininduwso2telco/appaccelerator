
package com.wso2telco.promotionalapp.model.response;

/**
 * Created by dinindu on 5/30/17.
 */

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourceURL",
    "deliveryInfo"
})
public class DeliveryInfoList {

    @JsonProperty("resourceURL")
    private String resourceURL;
    @JsonProperty("deliveryInfo")
    private List<DeliveryInfo> deliveryInfo = null;

    @JsonProperty("resourceURL")
    public String getResourceURL() {
        return resourceURL;
    }

    @JsonProperty("resourceURL")
    public void setResourceURL(String resourceURL) {
        this.resourceURL = resourceURL;
    }

    @JsonProperty("deliveryInfo")
    public List<DeliveryInfo> getDeliveryInfo() {
        return deliveryInfo;
    }

    @JsonProperty("deliveryInfo")
    public void setDeliveryInfo(List<DeliveryInfo> deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

}
