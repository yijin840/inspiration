package org.yijin.product;

import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author YiJin840
 * @program inspiration
 * @description
 * @since 2024-03-11 13:56
 **/
@Component
@RequiredArgsConstructor
public class MessageProducer {

    private final RocketMQTemplate rocketmqTemplate;

    public void sendMessage(List<String> list) {
        Message<List<String>> msg = MessageBuilder.withPayload(list).build();
        rocketmqTemplate.asyncSend("message_topic", msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        }, 1000);
    }

}
