package org.insp.sdk.client;

import org.insp.sdk.client.util.ConvertUtil;

import java.io.Serializable;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/22 16:39
 **/
public abstract class ProcessResponse implements Serializable {

    private static final long serialVersionUID = 3207072464909031645L;

    protected ProcessResponse convert(String response) {
        return ConvertUtil.covertResponse(response, this.getClass());
    }

}
