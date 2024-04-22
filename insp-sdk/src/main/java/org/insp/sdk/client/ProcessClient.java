package org.insp.sdk.client;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/22 16:36
 **/
public interface ProcessClient {

    String getClientName();
    void auth(ProcessRequest processRequest);
    ProcessResponse get(ProcessRequest processRequest);
    ProcessResponse post(ProcessRequest processRequest);
    ProcessResponse put(ProcessRequest processRequest);
    ProcessResponse delete(ProcessRequest processRequest);

}
