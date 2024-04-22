package org.yijin.enums;

import lombok.Getter;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 15:12
 **/
@Getter
public enum LocalStatus {

    START("status", 0),

    RESTART("restart", 1),

    FAILURE("failure", 2)
    ;


    private final String status;

    private final Integer value;

    LocalStatus(String status, Integer value) {
        this.status = status;
        this.value = value;
    }


}
