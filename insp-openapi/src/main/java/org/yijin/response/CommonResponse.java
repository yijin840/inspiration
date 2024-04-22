package org.yijin.response;

import com.alibaba.fastjson.JSONObject;
import lombok.*;


/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/3 17:31
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResponse<T> extends BaseResponse<T> {
    private static final long serialVersionUID = 560259443816051301L;

    private Integer code;
    private T data;
    private String message;


    @Override
    public Boolean isSuccess() {
        return code == 200;
    }
}
