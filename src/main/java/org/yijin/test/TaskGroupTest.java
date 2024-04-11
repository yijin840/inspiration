package org.yijin.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.IOException;
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

        List<String> list2 = new ArrayList<>();
        list2.add("https://baidu.com");
        list2.add("https://juejin.cn/");
        list2.add("https://www.json.cn/");
        list2.add("https://www.bookstack.cn/");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        RequestGroupTask requestTask = new RequestGroupTask(list2, 3, "group task");
        requestTask.execute(executorService);
        List<String> requestResult = requestTask.getResult();
        stopWatch.stop();
        log.info("time ==> {}", stopWatch.getTotalTimeMillis());

        try {
            testNoGroup();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        stopWatch.start();
//        StringGroupTask groupTask = new StringGroupTask(list, 5);
//        groupTask.execute(executorService);
//        List<String> result = groupTask.getResult();
//        stopWatch.stop();
//        log.info("result ==> {}, time ==> {}", result, stopWatch.getTotalTimeMillis());

    }

    public void testNoGroup() throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<String> res = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("https://baidu.com");
        list2.add("https://juejin.cn/");
        list2.add("https://www.json.cn/");
        list2.add("https://www.bookstack.cn/");
        OkHttpClient client = new OkHttpClient();
        for (String s : list2) {
            Response execute = client.newCall(new Request.Builder().url(s).build()).execute();
            res.add(execute.body().string());
        }
        stopWatch.stop();
        log.info("time ==> {}", stopWatch.getTotalTimeMillis());
    }

}
