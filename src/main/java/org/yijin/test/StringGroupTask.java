package org.yijin.test;

import org.yijin.async.AbstractGroupTask;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/11 15:43
 **/
public class StringGroupTask extends AbstractGroupTask<String, String> {
    public StringGroupTask(List<String> groupList, int count) {
        super(groupList, count);
    }

    @Override
    protected List<String> groupTask(List<String> signleGroupList) {
        return signleGroupList.stream().map(s -> s + "=====").collect(Collectors.toList());
    }

    @Override
    public String taskName() {
        return "String Task";
    }

}
