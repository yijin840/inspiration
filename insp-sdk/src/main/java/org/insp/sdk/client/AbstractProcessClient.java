package org.insp.sdk.client;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.insp.sdk.client.enums.HttpMethodEnum;
import org.insp.sdk.client.exception.InspSdkException;

import java.io.Serializable;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/22 17:04
 **/
public abstract class AbstractProcessClient implements ProcessClient {

    protected boolean isInit = false;
    protected boolean needAuth = false;
    protected ProcessConfig config;
    protected ProcessRequest request;

    protected abstract void initConfig(ProcessConfig config);


    protected void init(ProcessConfig config) {
        initConfig(config);
        isInit = true;
        this.config = config;
    }

    @Override
    public ProcessResponse get(ProcessRequest processRequest) {
        if (needAuth) {
            auth(processRequest);
        }
        return null;
    }

    @Override
    public ProcessResponse post(ProcessRequest processRequest) {
        return null;
    }

    @Override
    public ProcessResponse put(ProcessRequest processRequest) {
        throw new InspSdkException("put method not support");
    }

    @Override
    public ProcessResponse delete(ProcessRequest processRequest) {
        throw new InspSdkException("delete method not support");
    }
    
}
