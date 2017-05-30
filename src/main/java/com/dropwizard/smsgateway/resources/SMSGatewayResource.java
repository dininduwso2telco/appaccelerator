package com.dropwizard.smsgateway.resources;

import com.dropwizard.smsgateway.AppConfiguration;
import com.dropwizard.smsgateway.handlers.SMSRequestHandler;
import com.dropwizard.smsgateway.smssender.SMSRequestConfiguration;
import org.apache.http.HttpResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by dinindu on 5/29/17.
 */


@Path("/appaccelerator")
@Produces(MediaType.APPLICATION_JSON)
public class SMSGatewayResource {

    private final AppConfiguration configuration;

    public SMSGatewayResource(AppConfiguration configuration) {
        this.configuration = configuration;
    }

    @POST
    @Path("/sendsms")
    public Response sendSMS(@FormParam("message") String message) throws IOException {

        SMSRequestHandler handler = new SMSRequestHandler(configuration);
        HttpResponse response = handler.handleSMSRequest(message);
        return Response
                .status(response.getStatusLine().getStatusCode())
                .entity(response.getEntity().getContent())
                .build();
    }
}
