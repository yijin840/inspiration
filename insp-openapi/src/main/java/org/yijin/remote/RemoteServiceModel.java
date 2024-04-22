package org.yijin.remote;

import lombok.Data;
import org.yijin.enums.RemoteStatus;

/**
 * 远端模型
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 15:08
 **/
@Data
public class RemoteServiceModel {

    private String remoteId;

    private String remoteMessage;

    private RemoteStatus remoteStatus;

}
