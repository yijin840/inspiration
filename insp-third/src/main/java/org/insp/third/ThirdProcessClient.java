package org.insp.third;

import org.insp.sdk.client.*;
import org.springframework.stereotype.Component;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/22 17:29
 **/
@Component
public class ThirdProcessClient extends AbstractProcessClient {


    @Override
    public ProcessClient getClient() {
        return this;
    }

    @Override
    public void auth(ProcessRequest processRequest) {

    }

    @Override
    protected void initConfig(ProcessConfig config) {

    }


}
