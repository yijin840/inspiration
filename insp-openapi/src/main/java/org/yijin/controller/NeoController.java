package org.yijin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yijin.model.ResponseResult;
import org.yijin.request.NeoRequest;
import org.yijin.response.NeoResponse;
import org.yijin.util.SlogUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/3/20 14:29
 **/
@RestController
@RequiredArgsConstructor
public class NeoController {

    private final SlogUtil slogUtil;

    @PostMapping("/neo")
    public ResponseResult neo(HttpServletRequest httpServletRequest,
                              @RequestBody NeoRequest request) {
        NeoResponse response = new NeoResponse();
        response.setAddress("ttt");
        response.setEmail("aaa");
        response.setReqId(response.getReqId());
        response.setPhone("1111");
        String slog = slogUtil.log("aaa", "bbb");
        System.out.println(slog);
        return ResponseResult.success(response);
    }

}
