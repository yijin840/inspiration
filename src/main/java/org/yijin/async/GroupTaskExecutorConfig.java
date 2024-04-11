package org.yijin.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/11 15:14
 **/
@Configuration
public class GroupTaskExecutorConfig {

    @Bean
    public ExecutorService executorService() {
        return new ThreadPoolExecutor(10,
                50,
                2000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());
    }

}
