package org.insp.sdk.client;

import lombok.Data;
import org.insp.sdk.client.enums.HttpMethodEnum;

import java.beans.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/22 17:03
 **/
@Data
public class ProcessRequest implements Serializable {

    private static final long serialVersionUID = -8941365790964151217L;

    private String url;

    private HttpMethodEnum method;

    private Map<String, String> header;

    private Map<String, String> params;

    private String requestEntity;

}
