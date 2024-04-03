package org.yijin.anno;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/3/21 11:15
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SLog {

    String value() default "";

    int idx();


}
