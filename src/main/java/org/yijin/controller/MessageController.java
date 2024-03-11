package org.yijin.controller;

import cn.hutool.core.lang.UUID;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yijin.product.MessageProducer;
import org.yijin.util.JsonUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YiJin840
 * @program inspiration
 * @description
 * @since 2024-03-11 13:14
 **/
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageProducer producer;

    private final ExecutorService executor = new ThreadPoolExecutor(3,
            5,
            5000,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5),
            new DefaultThreadFactory("message_thread_pool"),
            new ThreadPoolExecutor.AbortPolicy());

    @GetMapping("/message/send/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        //模拟一下发送10条信息，并且每条信息都有一个list，list中包含重复数据
        List<String> l1 = new ArrayList<>(10);
        List<String> l2 = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            DataPack dataPack = new DataPack();
            dataPack.setMessage(String.valueOf(i));
            dataPack.setId((long) i);
            dataPack.setName(String.valueOf(i));
            dataPack.setTime(new Date());
            l1.add(JsonUtil.toJson(dataPack));
        }
        for (int i = 5; i < 16; i++) {
            DataPack dataPack = new DataPack();
            dataPack.setMessage(UUID.randomUUID().toString());
            dataPack.setId((long) i);
            dataPack.setName(String.valueOf(i));
            dataPack.setTime(new Date());
            l2.add(JsonUtil.toJson(dataPack));
        }
        executor.submit(() -> producer.sendMessage(l1));
        executor.submit(() -> producer.sendMessage(l2));
        System.out.println("消息已经发送！");
    }

    @Data
    public static class DataPack {
        private Long id;
        private String name;
        private String message;
        private Date time;
    }

}
