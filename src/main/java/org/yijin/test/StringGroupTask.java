package org.yijin.test;

import org.yijin.async.AbstractGroupTask;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/11 15:43
 **/
public class StringGroupTask extends AbstractGroupTask<String, String> {
    public StringGroupTask(List<String> groupList, int count) {
        super(groupList, count, "string task");
    }

    @Override
    protected List<String> groupTask(List<String> signleGroupList) {
        return signleGroupList.stream().map(s -> s + "=====").collect(Collectors.toList());
    }

    /**
     * 自定义分组逻辑
     * @param pendingGroupList 待分组集合
     * @param count            分组数量
     * @return 分组
     */
    @Override
    public List<List<String>> groupByCount(List<String> pendingGroupList, int count) {

        return super.groupByCount(pendingGroupList, count);
    }
}
