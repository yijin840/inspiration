package org.yijin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program InspirationApplication
 * @description this is application main class
 * @author YiJin840
 * @since 2024-02-29
 **/
@SpringBootApplication
@MapperScan("org.yijin.mapper")
public class InspirationApplication {

    public static void main(String[] args) {
        SpringApplication.run(InspirationApplication.class, args);
    }

}
