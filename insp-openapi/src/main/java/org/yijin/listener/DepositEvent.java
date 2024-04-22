package org.yijin.listener;

import lombok.*;
import org.springframework.context.ApplicationEvent;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 14:14
 **/
@Setter
@Getter
public class DepositEvent extends ApplicationEvent {
    private static final long serialVersionUID = -6713633924508713129L;

    public DepositEvent(Object source) {
        super(source);
    }
}
