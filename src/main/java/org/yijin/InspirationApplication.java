package org.yijin;

import io.reactivex.rxjava3.core.Flowable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yijin.test.TaskGroupTest;

import javax.annotation.PostConstruct;

/**
 * @author YiJin840
 * @program InspirationApplication
 * @description this is application main class
 * @since 2024-02-29
 **/
@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class InspirationApplication {

    private final TaskGroupTest taskGroupTest;

    public static void main(String[] args) {
        SpringApplication.run(InspirationApplication.class, args);
    }

    @PostConstruct
    public void started() {
        log.info("test log info");
        taskGroupTest.test();
    }

}
