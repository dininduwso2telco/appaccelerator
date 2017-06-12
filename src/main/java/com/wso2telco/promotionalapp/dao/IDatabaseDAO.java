package com.wso2telco.promotionalapp.dao;

import com.wso2telco.promotionalapp.model.application.Application;
import com.wso2telco.promotionalapp.model.application.ReceiverList;
import org.mongojack.WriteResult;

import java.util.List;

/**
 * Created by dinindu on 6/11/17.
 */
public interface IDatabaseDAO {

    public Application getApplicationByAppId(String appId);

    public List<ReceiverList> getReceiverListByAppId(String appId);

}
