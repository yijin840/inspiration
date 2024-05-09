package org.insp.sdk.client.util;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/5/9 11:05
 **/
public abstract class FuncChain {

    private boolean isLast = false;

    void chain(String status) {
        process(status);
        if(!isLast) {
            next(status);
        }
    }

    public abstract void next(String status);
    public abstract void process(String status);

}
