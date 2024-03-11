package org.yijin.entity;

import lombok.Data;

/**
 * @author YiJin840
 * @program inspiration
 * @description user
 * @since 2024-02-29 11:11
 **/
@Data
public class User {

    private Long id;

    private String name;

    private String password;

    private String email;

    private String phone;

    public String getKey() {
        return this.id + ":" + this.name;
    }

}
