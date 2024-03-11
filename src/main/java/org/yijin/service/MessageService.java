package org.yijin.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.yijin.controller.MessageController;
import org.yijin.util.JsonUtil;

import java.util.List;

/**
 * @author YiJin840
 * @program inspiration
 * @description message controller
 * @since 2024-03-11 12:44MessageService
 **/
@Component
@RocketMQMessageListener(topic = "message_topic", consumerGroup = "message_consumer")
public class MessageService implements RocketMQListener<List<String>> {

    @Override
    public void onMessage(List<String> message) {
        for (String msg : message) {
            MessageController.DataPack pack = JsonUtil.toObject(msg, MessageController.DataPack.class);
            System.out.println(pack);
        }
    }
}
