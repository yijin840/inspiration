package org.yijin.util;

import org.springframework.stereotype.Component;
import org.yijin.anno.SLog;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/3/21 11:54
 **/
@Component
public class SlogUtil {

    @SLog(idx = 1)
    public String log(String a, String b) {
        System.out.println("11111111");

        return b;
    }

}
