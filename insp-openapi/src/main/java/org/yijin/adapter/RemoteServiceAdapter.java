package org.yijin.adapter;

import org.springframework.stereotype.Component;
import org.yijin.model.LocalServiceModel;
import org.yijin.enums.LocalStatus;
import org.yijin.enums.RemoteStatus;
import org.yijin.remote.RemoteServiceModel;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 15:15
 **/
@Component
public class RemoteServiceAdapter {

    public LocalServiceModel converModelToLocalServiceModel(RemoteServiceModel remoteServiceModel) {
        LocalServiceModel localServiceModel = new LocalServiceModel();
        localServiceModel.setRemoteId(remoteServiceModel.getRemoteId());
        localServiceModel.setMsg(remoteServiceModel.getRemoteMessage());
        localServiceModel.setStatus(convertStatusToLocalStatus(remoteServiceModel.getRemoteStatus()));
        return localServiceModel;
    }

    public LocalStatus convertStatusToLocalStatus(RemoteStatus remoteStatus) {
        LocalStatus localStatus;
        if (remoteStatus.getStatus().equals("success")) {
            localStatus = LocalStatus.START;
        } else if (remoteStatus.getStatus().equals("fail")) {
            localStatus = LocalStatus.FAILURE;
        } else {
            localStatus = LocalStatus.RESTART;
        }
        return localStatus;
    }


}
