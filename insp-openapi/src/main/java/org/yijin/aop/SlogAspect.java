package org.yijin.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.yijin.anno.SLog;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/3/21 11:15
 **/
@Component
@Aspect
public class SlogAspect {

    @Around("@annotation(org.yijin.anno.SLog)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("222222222");
        MethodSignature method = (MethodSignature) joinPoint.getSignature();
        SLog sLog = method.getMethod().getAnnotation(SLog.class);
        int idx = sLog.idx();
        joinPoint.getSignature().getClass().getAnnotations();
        return joinPoint.proceed(joinPoint.getArgs());
    }

}
