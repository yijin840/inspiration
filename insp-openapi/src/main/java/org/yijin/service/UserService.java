package org.yijin.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.yijin.model.UserLog;
import org.yijin.model.UserRequest;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/3/22 17:03
 **/
@Component
@Slf4j
public class UserService {

    public UserRequest process(UserRequest request) {
        UserLog userLog = new UserLog();
        BeanUtils.copyProperties(request, userLog);
        log.info(".... log ==> {}", JSONObject.toJSONString(userLog));

        return request;
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("aaa");
        userRequest.setPassword("bbb");
        userRequest.setMail("ccc");
        userRequest.setPhone("ddd");


        UserRequest process = userService.process(userRequest);
        System.out.println(process.equals(userRequest));
        System.out.println(process == userRequest);
        System.out.println(process);
    }

}
