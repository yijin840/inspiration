package org.yijin.util;

import com.alibaba.fastjson.JSONObject;
import org.yijin.response.CommonResponse;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/3 17:57
 **/
public class RespAdaptor {

    public static CommonResponse<Object> parse(String resp) {
        return parse(resp, Object.class);
    }

    public static <T> CommonResponse<T> parse(String resp, Class<T> tClass) {
        JSONObject respObject = JSONObject.parseObject(resp);
        Integer code = respObject.getInteger("code");
        String message = respObject.getString("message");
        T data = respObject.getJSONObject("data").toJavaObject(tClass);
        return CommonResponse.<T>builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }



}
