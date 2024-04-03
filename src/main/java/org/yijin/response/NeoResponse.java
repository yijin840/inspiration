package org.yijin.response;

import lombok.Data;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/3/20 14:32
 **/
@Data
public class NeoResponse {

    private Long reqId;

    private String address;

    private String email;

    private String phone;

}
