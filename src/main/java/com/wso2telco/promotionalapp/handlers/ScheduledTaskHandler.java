package com.wso2telco.promotionalapp.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wso2telco.promotionalapp.configurations.PromotionalAppConfiguration;
import com.wso2telco.promotionalapp.dao.IDatabaseDAO;
import com.wso2telco.promotionalapp.model.application.Application;
import com.wso2telco.promotionalapp.model.application.ReceiverList;
import com.wso2telco.promotionalapp.model.request.OutboundSMSMessageRequest;
import com.wso2telco.promotionalapp.model.request.OutboundSMSTextMessage;
import com.wso2telco.promotionalapp.model.request.ReceiptRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpHeaders.USER_AGENT;

/**
 * Created by dinindu on 6/11/17.
 */
public class ScheduledTaskHandler implements Runnable {

    private final IDatabaseDAO databaseDAO;
    private final PromotionalAppConfiguration promotionalAppConfiguration;

    public ScheduledTaskHandler(PromotionalAppConfiguration promotionalAppConfiguration, IDatabaseDAO databaseDAO) {
        this.promotionalAppConfiguration = promotionalAppConfiguration;
        this.databaseDAO = databaseDAO;
    }

    public void run() {
        System.out.println("Hello !!");
        try {
            sendMessage();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() throws JsonProcessingException, UnsupportedEncodingException {
        Application application = databaseDAO.getApplicationByAppId(promotionalAppConfiguration.getAppId());

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(promotionalAppConfiguration.getSmsgateway());

        // add header
        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Content-Type","application/json");
        post.setHeader("Authorization","Bearer "+application.getAppAccessToken());//f8e9a37a-de10-3e73-b314-ac94cbfb8ee9");

        OutboundSMSTextMessage textMessage = new OutboundSMSTextMessage();
        textMessage.setMessage(application.getAppConfig().getMessage());
        OutboundSMSMessageRequest outboundSMSMessageRequest = new OutboundSMSMessageRequest();
        outboundSMSMessageRequest.setOutboundSMSTextMessage(textMessage);
        outboundSMSMessageRequest.setClientCorrelator("334589");
        ReceiptRequest receiptRequest = new ReceiptRequest();
        receiptRequest.setCallbackData("Some data");
        receiptRequest.setNotifyURL(application.getAppCallbackUrl());
        outboundSMSMessageRequest.setReceiptRequest(receiptRequest);
        outboundSMSMessageRequest.setSenderAddress("tel:+"+application.getAppPort());
        outboundSMSMessageRequest.setSenderName(application.getAppMask());

        List<String> addresses = new ArrayList<String>();
        List<ReceiverList> receiverList = application.getAppConfig().getReceiverList();
        for(int receiver = 0; receiver< receiverList.size();receiver++){
            addresses.add("tel:"+receiverList.get(receiver).getMsisdn());
        }
        outboundSMSMessageRequest.setAddress(addresses);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(outboundSMSMessageRequest);
        StringEntity entity = new StringEntity(json);
        post.setEntity(entity);

        /*HttpResponse response = null;

        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println(json);
    }
}
