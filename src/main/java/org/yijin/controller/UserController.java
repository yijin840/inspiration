package org.yijin.controller;

import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yijin.cache.RedisCache;
import org.yijin.context.UserContext;
import org.yijin.entity.User;
import org.yijin.request.LoginRequest;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author YiJin840
 * @program inspiration
 * @description UserController
 * @since 2024-02-29 11:06
 **/
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final RedisCache<User> redisCache;

    /**
     * 核心线程数 corePoolSize
     * 最大线程数 maximumPoolSize
     * 保持存活时间 keepAliveTime
     * 单位 Unit
     * 阻塞队列 workQueue
     * 默认的线程工厂 threadFactory
     * 拒绝策略 handler
     */
    private final ExecutorService executor = new ThreadPoolExecutor(3,
            5,
            5000,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5),
            new DefaultThreadFactory("UserThreadPool"),
            new ThreadPoolExecutor.AbortPolicy());

    @PostMapping("/register")
    public void register(@RequestBody LoginRequest request) {
        System.out.println(request.getName());
        System.out.println(request.getPassword());

    }


    @PostMapping("/login")
    public void login(@RequestBody LoginRequest request) {
        System.out.println("login");
        //当前登录用户
        User user = UserContext.get();
        if(Objects.nonNull(user)) {
            UserContext.remove();
        }
        //异步去执行不同任务
        Future<?> redisTask = executor.submit(() -> redisCache.set(user.getKey(), user));
        Future<?> contextTask = executor.submit(() -> UserContext.set(user));
        if(redisTask.isDone() && contextTask.isDone()) {
            log.info("task is done.");
        }
    }


}
