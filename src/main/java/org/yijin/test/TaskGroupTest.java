package org.yijin.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/11 15:27
 **/
@Component
@RequiredArgsConstructor
@Slf4j
public class TaskGroupTest {

    private final ExecutorService executorService;

    public void test() {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("112");
        list.add("113");
        list.add("114");
        list.add("22");
        list.add("223");
        list.add("224");

        StringGroupTask groupTask = new StringGroupTask(list, 5);
        groupTask.execute(executorService);

        List<String> result = groupTask.getResult();
        log.info("result ==> {}", result);
    }


}
