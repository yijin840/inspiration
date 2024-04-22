package org.insp.sdk.client.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.insp.sdk.client.ProcessResponse;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/22 17:04
 **/
public class ConvertUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T covertResponse(String response, Class<T> tClass) {
        T obj;
        try {
            obj = MAPPER.readValue(response, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

}
