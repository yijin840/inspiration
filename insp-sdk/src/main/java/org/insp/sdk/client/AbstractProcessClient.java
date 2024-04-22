package org.insp.sdk.client;

import org.insp.sdk.client.enums.HttpMethodEnum;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/22 17:04
 **/
public abstract class AbstractProcessClient implements ProcessClient {

    protected boolean isInit = false;

    protected ProcessRequest request;

    protected abstract void initConfig(ProcessConfig config);


    protected void init(ProcessConfig config) {
        initConfig(config);
        isInit = true;
    }

    @Override
    public ProcessResponse get(ProcessRequest processRequest) {
        auth(processRequest);



        return null;
    }

    @Override
    public ProcessResponse post(ProcessRequest processRequest) {
        return null;
    }

    @Override
    public ProcessResponse put(ProcessRequest processRequest) {
        throw new RuntimeException("put method not support");
    }

    @Override
    public ProcessResponse delete(ProcessRequest processRequest) {
        throw new RuntimeException("put method not support");
    }

}
