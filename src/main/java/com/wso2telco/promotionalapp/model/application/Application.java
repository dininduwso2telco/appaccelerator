
package com.wso2telco.promotionalapp.model.application;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "appGroupId",
        "appId",
        "appDeployPort",
        "appName",
        "appDescription",
        "appCallbackUrl",
        "appPort",
        "appMask",
        "isSubscriberBased",
        "appType",
        "appStatus",
        "userID",
        "appThrottlingTier",
        "appConfig",
        "appAccessToken"
})
public class Application {

    @JsonProperty("appGroupId")
    private String appGroupId;
    @JsonProperty("appId")
    private String appId;
    @JsonProperty("appDeployPort")
    private int appDeployPort;
    @JsonProperty("appName")
    private String appName;
    @JsonProperty("appDescription")
    private String appDescription;
    @JsonProperty("appCallbackUrl")
    private String appCallbackUrl;
    @JsonProperty("appPort")
    private Integer appPort;
    @JsonProperty("appMask")
    private String appMask;
    @JsonProperty("isSubscriberBased")
    private Boolean isSubscriberBased;
    @JsonProperty("appType")
    private String appType;
    @JsonProperty("appStatus")
    private String appStatus;
    @JsonProperty("userID")
    private String userID;
    @JsonProperty("appThrottlingTier")
    private String appThrottlingTier;
    @JsonProperty("appConfig")
    private AppConfig appConfig;
    @JsonProperty("appAccessToken")
    private String appAccessToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("appGroupId")
    public String getAppGroupId() {
        return appGroupId;
    }

    @JsonProperty("appGroupId")
    public void setAppGroupId(String appGroupId) {
        this.appGroupId = appGroupId;
    }

    @JsonProperty("appId")
    public String getAppId() {
        return appId;
    }

    @JsonProperty("appId")
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @JsonProperty("appDeployPort")
    public int getAppDeployPort() {
        return appDeployPort;
    }

    @JsonProperty("appDeployPort")
    public void setAppDeployPort(int appDeployPort) {
        this.appDeployPort = appDeployPort;
    }


    @JsonProperty("appName")
    public String getAppName() {
        return appName;
    }

    @JsonProperty("appName")
    public void setAppName(String appName) {
        this.appName = appName;
    }

    @JsonProperty("appDescription")
    public String getAppDescription() {
        return appDescription;
    }

    @JsonProperty("appDescription")
    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    @JsonProperty("appCallbackUrl")
    public String getAppCallbackUrl() {
        return appCallbackUrl;
    }

    @JsonProperty("appCallbackUrl")
    public void setAppCallbackUrl(String appCallbackUrl) {
        this.appCallbackUrl = appCallbackUrl;
    }

    @JsonProperty("appPort")
    public Integer getAppPort() {
        return appPort;
    }

    @JsonProperty("appPort")
    public void setAppPort(Integer appPort) {
        this.appPort = appPort;
    }

    @JsonProperty("appMask")
    public String getAppMask() {
        return appMask;
    }

    @JsonProperty("appMask")
    public void setAppMask(String appMask) {
        this.appMask = appMask;
    }

    @JsonProperty("isSubscriberBased")
    public Boolean getIsSubscriberBased() {
        return isSubscriberBased;
    }

    @JsonProperty("isSubscriberBased")
    public void setIsSubscriberBased(Boolean isSubscriberBased) {
        this.isSubscriberBased = isSubscriberBased;
    }

    @JsonProperty("appType")
    public String getAppType() {
        return appType;
    }

    @JsonProperty("appType")
    public void setAppType(String appType) {
        this.appType = appType;
    }

    @JsonProperty("appStatus")
    public String getAppStatus() {
        return appStatus;
    }

    @JsonProperty("appStatus")
    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    @JsonProperty("userID")
    public String getUserID() {
        return userID;
    }

    @JsonProperty("userID")
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @JsonProperty("appThrottlingTier")
    public String getAppThrottlingTier() {
        return appThrottlingTier;
    }

    @JsonProperty("appThrottlingTier")
    public void setAppThrottlingTier(String appThrottlingTier) {
        this.appThrottlingTier = appThrottlingTier;
    }

    @JsonProperty("appConfig")
    public AppConfig getAppConfig() {
        return appConfig;
    }

    @JsonProperty("appConfig")
    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public String getAppAccessToken() {
        return appAccessToken;
    }

    public void setAppAccessToken(String appAccessToken) {
        this.appAccessToken = appAccessToken;
    }
}
