package com.wso2telco.promotionalapp.configurations;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by dinindu on 6/11/17.
 */
public class DatabaseConfiguration {

    @NotNull
    private String host;

    @Min(1)
    @Max(65535)
    private int port;

    @NotNull
    private String db;

    @NotNull
    private String username;

    @NotNull
    private String password;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
