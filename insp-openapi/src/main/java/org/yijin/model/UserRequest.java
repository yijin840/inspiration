package org.yijin.model;

import lombok.Data;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/3/22 17:03
 **/
@Data
public class UserRequest {

    private String username;

    private String password;

    private String mail;

    private String phone;

}
