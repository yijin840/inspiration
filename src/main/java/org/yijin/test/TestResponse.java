package org.yijin.test;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;
import org.yijin.response.CommonResponse;
import org.yijin.util.RespAdaptor;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/3 17:40
 **/
public class TestResponse {

    public static void main(String[] args) {
        MockEntity hello = MockEntity.builder().id("123").age("23").name("hello").build();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSONObject.toJSONString(hello));
        jsonObject.put("code", 123);
        jsonObject.put("message", "");
        String jsonString = jsonObject.toJSONString();

        CommonResponse<Object> cp = RespAdaptor.parse(jsonString);

        System.out.println(cp);
    }

    @Data
    @Builder
    public static class MockEntity {
        private String name;
        private String age;
        private String id;
    }

}
