package org.yijin.request;

import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author YiJin840
 * @program inspiration
 * @description login request
 * todo 后面要做入参校验
 * @since 2024-02-29 11:25
 **/
@Data
public class LoginRequest {

    @NotNull
    private String name;

    private String password;

}
