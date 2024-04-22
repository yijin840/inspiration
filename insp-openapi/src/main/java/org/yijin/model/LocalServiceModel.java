package org.yijin.model;

import lombok.Data;
import org.yijin.enums.LocalStatus;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 15:10
 **/
@Data
public class LocalServiceModel {

    private String id;

    private String remoteId;

    private String msg;

    private LocalStatus status;

}
