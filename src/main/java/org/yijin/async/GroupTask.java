package org.yijin.async;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/11 14:24
 **/
public interface GroupTask<T, R> {

    /**
     * 根据数量对集合分组
     *
     * @param pendingGroupList 待分组集合
     * @param count            分组数量
     * @return 分好组的集合
     */
    List<List<T>> groupByCount(List<T> pendingGroupList, int count);

    /**
     * 分配组任务
     */
    void assignGroupTasks(List<List<T>> finishedGroupList);

    /**
     * @return 任务名称
     */
    String taskName();

    void execute(ExecutorService executor);

    /**
     * @return 分组前的集合
     */
    List<T> getGroupList();

    /**
     * @return 分组完成后的集合
     */
    List<List<T>> getFinishedGroupList();

    /**
     * @return 任务队列
     */
    List<FutureTask<List<R>>> getAllTask();

    List<R> getResult();

}
