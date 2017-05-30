package com.dropwizard.smsgateway.handlers;

import com.dropwizard.smsgateway.AppConfiguration;
import com.dropwizard.smsgateway.smssender.SMSRequestConfiguration;
import com.dropwizard.smsgateway.smssender.SMSTextMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static javax.ws.rs.core.HttpHeaders.USER_AGENT;

/**
 * Created by dinindu on 5/29/17.
 */
public class SMSRequestHandler {

    private final AppConfiguration configuration;

    public SMSRequestHandler(AppConfiguration configuration) {
        this.configuration = configuration;
    }

    public HttpResponse handleSMSRequest(String message) throws UnsupportedEncodingException, JsonProcessingException {
        String url = this.configuration.getSmsgateway();

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Content-Type","application/json");
        post.setHeader("Authorization","Bearer f8e9a37a-de10-3e73-b314-ac94cbfb8ee9");

        SMSTextMessage textMessage = new SMSTextMessage(message);
        configuration.getSmsrequest().getOutboundSMSMessageRequest().setOutboundSMSTextMessage(textMessage);

        SMSRequestConfiguration temp = configuration.getSmsrequest();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(temp);
        StringEntity entity = new StringEntity(json);
        post.setEntity(entity);

        HttpResponse response = null;

        try {
            response = client.execute(post);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return response;
        }
    }
}
