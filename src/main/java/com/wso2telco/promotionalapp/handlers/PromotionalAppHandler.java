package com.wso2telco.promotionalapp.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wso2telco.promotionalapp.configurations.PromotionalAppConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.wso2telco.promotionalapp.dao.DatabaseDAOImplementation;
import com.wso2telco.promotionalapp.dao.IDatabaseDAO;
import com.wso2telco.promotionalapp.managed.DatabaseManaged;
import com.wso2telco.promotionalapp.model.application.Application;
import org.apache.http.HttpResponse;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.time.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by dinindu on 5/29/17.
 */

public class PromotionalAppHandler {

    private final PromotionalAppConfiguration configuration;
    private final DatabaseManaged databaseManaged;
    private final IDatabaseDAO databaseDAO;
    private final ObjectMapper mapper;
    private ScheduledExecutorService service;

    public PromotionalAppHandler(PromotionalAppConfiguration configuration, DatabaseManaged databaseManaged)
    {
        this.configuration = configuration;
        this.databaseManaged = databaseManaged;
        this.databaseDAO = new DatabaseDAOImplementation(databaseManaged);
        this.mapper = new ObjectMapper();
        this.service = Executors.newSingleThreadScheduledExecutor();
        this.initialize();
    }

    private void initialize() {
        if(service.isShutdown())
        {
            service = Executors.newSingleThreadScheduledExecutor();
        }
        String appId = this.configuration.getAppId();
        Application application = this.databaseDAO.getApplicationByAppId(appId);
        String time = application.getAppConfig().getSchedule().getDateTime();
        LocalTime scheduledTime = LocalTime.parse(time);
        Long delay = getFirstMessageDelay(scheduledTime);

        boolean isScheduled = application.getAppConfig().getSchedule().getIsSchedule();
        if(isScheduled) {
            int period = getMessageRepeatPeriod(scheduledTime,application.getAppConfig().getSchedule().getRepeat());
            service.scheduleAtFixedRate(new ScheduledTaskHandler(configuration, databaseDAO), delay, period, TimeUnit.SECONDS);
        }
        else {
            service.schedule(new ScheduledTaskHandler(configuration, databaseDAO),delay,TimeUnit.SECONDS);
        }
    }

    public HttpResponse handleSMSRequest(String message) throws UnsupportedEncodingException, JsonProcessingException, ParseException {
        String url = this.configuration.getSmsgateway();
        String appId = this.configuration.getAppId();

        Application application = this.databaseDAO.getApplicationByAppId(appId);

        boolean isScheduled = application.getAppConfig().getSchedule().getIsSchedule();
        if(isScheduled) {
            System.out.println("Scheduled message");
            String time = application.getAppConfig().getSchedule().getDateTime();
            LocalTime scheduledTime = LocalTime.parse(time);
            Long delay = getFirstMessageDelay(scheduledTime);
            int period = getMessageRepeatPeriod(scheduledTime,application.getAppConfig().getSchedule().getRepeat());
            service.scheduleAtFixedRate(new ScheduledTaskHandler(configuration, databaseDAO), delay, period, TimeUnit.SECONDS);
        }
        /*HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Content-Type","application/json");
        post.setHeader("Authorization","Bearer f8e9a37a-de10-3e73-b314-ac94cbfb8ee9");

        OutboundSMSTextMessage textMessage = new OutboundSMSTextMessage();
        textMessage.setMessage(message);
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
        }*/
        return null;
    }

    private int getMessageRepeatPeriod(LocalTime scheduledTime, String repeat) {
        int period = 0;
        if(repeat.equals("HOURLY"))
            period = 60*60;
        else if(repeat.equals("WEEKLY"))
            period = 60*60*24*7;
        else if(repeat.equals("DAILY"))
            period = 10;
        return period;
    }

    private Long getFirstMessageDelay(LocalTime scheduledTime) {
        int targetHour = scheduledTime.getHour();
        int targetMin = scheduledTime.getMinute();
        int targetSec = scheduledTime.getSecond();

        LocalDateTime localNow = LocalDateTime.now();
        ZoneId currentZone = ZoneId.systemDefault();
        ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
        ZonedDateTime zonedNextTarget = zonedNow.withHour(targetHour).withMinute(targetMin).withSecond(targetSec);
        if(zonedNow.compareTo(zonedNextTarget) > 0)
            zonedNextTarget = zonedNextTarget.plusDays(1);

        Duration duration = Duration.between(zonedNow, zonedNextTarget);
        Long delay = duration.getSeconds();
        return delay;
    }

    public void update()
    {
        service.shutdown();
        initialize();
    }
}
