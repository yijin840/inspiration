package org.yijin.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yijin.entity.ResponseResult;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/3/20 14:48
 **/
@RestControllerAdvice
public class ValidException {

    /**
     * 处理所有异常
     *
     * @return 处理所有异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult requiredException(Exception exception) {
        return ResponseResult.fail(null, exception.getMessage(), 402);
    }

    /**
     * 处理所有异常
     *
     * @return 处理所有异常
     */
    @ExceptionHandler(Throwable.class)
    public ResponseResult otherException(Throwable throwable) {
        return ResponseResult.fail(null, throwable.getMessage(), 402);
    }

}
