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

    private static final String CLIENT_NAME = "third-process-client";

    @Override
    public String getClientName() {
        return CLIENT_NAME;
    }

    @Override
    public void auth(ProcessRequest processRequest) {

    }

    @Override
    protected void initConfig(ProcessConfig config) {

    }


}
