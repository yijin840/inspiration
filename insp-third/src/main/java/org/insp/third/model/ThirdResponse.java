package org.insp.third.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.insp.sdk.client.ProcessResponse;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/22 17:24
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class ThirdResponse extends ProcessResponse {
    private static final long serialVersionUID = 4342065955716870721L;

    private String data;

    private String code;

    private String message;

}
