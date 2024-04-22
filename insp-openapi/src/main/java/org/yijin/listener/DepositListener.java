package org.yijin.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/18 12:10
 **/
@Component
public class DepositListener implements ApplicationListener<DepositEvent> {

    @Override
    public void onApplicationEvent(DepositEvent depositEvent) {
        //监听
        System.out.println("deposit 监听器");
        System.out.println(depositEvent);
    }
}
