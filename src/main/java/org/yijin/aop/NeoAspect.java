package org.yijin.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.yijin.entity.ResponseResult;
import org.yijin.request.NeoRequest;

import java.util.concurrent.*;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/3/20 14:34
 **/
@Aspect
@Component
public class NeoAspect {

    @Pointcut("execution(* org.yijin.controller.NeoController.neo(..))")
    private void pointCnt() {
    }

    @Around("pointCnt()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        NeoRequest arg = (NeoRequest) joinPoint.getArgs()[1];
        System.out.println("123");
        try {
            new ForkJoinPool().execute(() -> {

            });
            ResponseResult proceed = (ResponseResult)joinPoint.proceed();
            System.out.println(proceed);
        } catch (Throwable e) {
            String jsonString = JSONObject.toJSONString(e.getMessage());
            System.out.println(jsonString);
            throw e;
        }
    }

}
