package org.yijin.entity;

import lombok.Data;

/**
 * @author YiJin840
 * @program inspiration
 * @description Response result
 * @since 2024-02-29 11:12
 **/
@Data
public class ResponseResult {

    private Object data;

    private String message;

    private int code;

    /**
     * 成功请求
     * @param data 数据
     * @return 响应结果
     */
    public static ResponseResult success(Object data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(200);
        responseResult.setMessage("success");
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * 成功请求
     * @param data 数据
     * @return 响应结果
     */
    public static ResponseResult fail(Object data, String message, int code) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        responseResult.setData(data);
        return responseResult;
    }


}
