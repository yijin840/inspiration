package org.yijin.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.yijin.async.AbstractGroupTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/11 16:48
 **/
public class RequestGroupTask extends AbstractGroupTask<String, String> {
    public RequestGroupTask(List<String> groupList, int count, String taskName) {
        super(groupList, count, taskName);
    }

    @Override
    protected List<String> groupTask(List<String> signleGroupList) {
        List<String> list = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        for (String url : signleGroupList) {
            try {
                Response response = client.newCall(new Request.Builder().url(url).build()).execute();
                list.add(response.body().string());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }
}
