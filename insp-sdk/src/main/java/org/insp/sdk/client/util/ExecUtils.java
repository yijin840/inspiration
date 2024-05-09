package org.insp.sdk.client.util;

import java.util.function.Consumer;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/5/8 15:49
 **/
public class ExecUtils {
    private static void execute(Boolean enable, Consumer<Boolean> consumer) {
        if(Boolean.TRUE.equals(enable)) {
            consumer.accept(true);
        }
    }
}
