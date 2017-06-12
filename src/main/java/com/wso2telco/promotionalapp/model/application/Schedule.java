
package com.wso2telco.promotionalapp.model.application;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "isSchedule",
    "dateTime",
    "repeat"
})
public class Schedule {

    @JsonProperty("isSchedule")
    private Boolean isSchedule;
    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("repeat")
    private String repeat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isSchedule")
    public Boolean getIsSchedule() {
        return isSchedule;
    }

    @JsonProperty("isSchedule")
    public void setIsSchedule(Boolean isSchedule) {
        this.isSchedule = isSchedule;
    }

    @JsonProperty("dateTime")
    public String getDateTime() {
        return dateTime;
    }

    @JsonProperty("dateTime")
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty("repeat")
    public String getRepeat() {
        return repeat;
    }

    @JsonProperty("repeat")
    public void setRepeat(String repeat) {
        this.repeat = repeat;
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
