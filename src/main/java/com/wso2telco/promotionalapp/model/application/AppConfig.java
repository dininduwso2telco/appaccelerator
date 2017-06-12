
package com.wso2telco.promotionalapp.model.application;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appKeyword",
    "candidates",
    "isCSV",
    "receiverList",
    "schedule",
    "message",
    "received"
})
public class AppConfig {

    @JsonProperty("appKeyword")
    private String appKeyword;
    @JsonProperty("isCSV")
    private Boolean isCSV;
    @JsonProperty("receiverList")
    private List<ReceiverList> receiverList = null;
    @JsonProperty("schedule")
    private Schedule schedule;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("appKeyword")
    public String getAppKeyword() {
        return appKeyword;
    }

    @JsonProperty("appKeyword")
    public void setAppKeyword(String appKeyword) {
        this.appKeyword = appKeyword;
    }

    @JsonProperty("isCSV")
    public Boolean getIsCSV() {
        return isCSV;
    }

    @JsonProperty("isCSV")
    public void setIsCSV(Boolean isCSV) {
        this.isCSV = isCSV;
    }

    @JsonProperty("receiverList")
    public List<ReceiverList> getReceiverList() {
        return receiverList;
    }

    @JsonProperty("receiverList")
    public void setReceiverList(List<ReceiverList> receiverList) {
        this.receiverList = receiverList;
    }

    @JsonProperty("schedule")
    public Schedule getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
