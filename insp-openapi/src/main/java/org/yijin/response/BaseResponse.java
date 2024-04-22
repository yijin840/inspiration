package org.yijin.response;

import java.io.Serializable;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/3 17:27
 **/
public abstract class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 7277063788632851173L;

    /**
     *
     * @return 响应是否成功
     */
    public abstract Boolean isSuccess();

}
