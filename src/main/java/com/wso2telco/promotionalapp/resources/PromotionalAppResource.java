package com.wso2telco.promotionalapp.resources;

import com.wso2telco.promotionalapp.configurations.PromotionalAppConfiguration;
import com.wso2telco.promotionalapp.handlers.PromotionalAppHandler;
import org.apache.http.HttpResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by dinindu on 5/29/17.
 */

@Path("/app")
@Produces(MediaType.APPLICATION_JSON)
public class PromotionalAppResource {

    private final PromotionalAppHandler promotionalAppHandler;

    public PromotionalAppResource(PromotionalAppHandler promotionalAppHandler) {
        this.promotionalAppHandler = promotionalAppHandler;
    }

    @POST
    @Path("/sendsms")
    public Response sendSMS(@FormParam("message") String message) throws IOException, ParseException {

        System.out.println(message);
        //HttpResponse response = promotionalAppHandler.handleSMSRequest(message);
        //promotionalAppHandler.update();
        return Response
                .ok()
                .build();
    }
}
