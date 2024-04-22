package org.yijin.enums;

import lombok.Getter;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 15:11
 **/
public enum RemoteStatus {

    SUCCESS("success"),
    FAIL("fail"),
    RETRY("retry");


    @Getter
    private final String status;

    RemoteStatus(String status) {
        this.status = status;
    }


}
