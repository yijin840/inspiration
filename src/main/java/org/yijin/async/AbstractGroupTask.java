package org.yijin.async;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * @author : wys
 * @email : yijin840@gmail.com
 * @created : 2024/4/11 14:33
 **/
@Slf4j
public abstract class AbstractGroupTask<T, R> implements GroupTask<T, R> {

    private final List<T> groupList;
    private final List<List<T>> finishedGroupList;
    private final List<FutureTask<List<R>>> FUTURE_TASK_LIST;
    private List<R> result;
    private volatile Boolean isRunning;
    private static final int DEFAULT_COUNT = 5;
    private final String taskName;

    public AbstractGroupTask(List<T> groupList, int count, String taskName) {
        this.groupList = groupList;
        this.finishedGroupList = groupByCount(groupList, count);
        this.FUTURE_TASK_LIST = new ArrayList<>();
        this.isRunning = false;
        this.taskName = taskName;
    }

    public AbstractGroupTask(List<T> groupList, String taskName) {
        this(groupList, DEFAULT_COUNT, taskName);
    }

    public AbstractGroupTask(List<T> groupList) {
        this(groupList, DEFAULT_COUNT, null);
    }


    @Override
    public List<List<T>> groupByCount(List<T> pendingGroupList, int count) {
        if (pendingGroupList == null || pendingGroupList.isEmpty()) {
            throw new RuntimeException("pending group list is empty");
        }
        List<List<T>> finishedGroupList = new ArrayList<>();
        //假如数量不足，每一个算一个
        if (pendingGroupList.size() < count) {
            finishedGroupList.addAll(pendingGroupList.stream().map(task -> {
                List<T> groupTaskList = new ArrayList<>();
                groupTaskList.add(task);
                return groupTaskList;
            }).collect(Collectors.toList()));
        } else {
            int singleCount = (int) Math.round(pendingGroupList.size() * 1.0 / count);
            for (int i = 0; i < count; i++) {
                int start = i * singleCount;
                int end = Math.min(start + singleCount, pendingGroupList.size());
                finishedGroupList.add(pendingGroupList.subList(start, end));
            }
        }
        return finishedGroupList;
    }

    @Override
    public void assignGroupTasks(List<List<T>> finishedGroupList) {
        log.info("{} is start running.", this.taskName());
        finishedGroupList.forEach(group ->
                FUTURE_TASK_LIST.add(new FutureTask<>(() -> groupTask(group))));
        this.isRunning = true;
    }

    protected abstract List<R> groupTask(List<T> signleGroupList);

    @Override
    public List<T> getGroupList() {
        return this.groupList;
    }

    @Override
    public List<List<T>> getFinishedGroupList() {
        return this.finishedGroupList;
    }

    @Override
    public List<FutureTask<List<R>>> getAllTask() {
        return FUTURE_TASK_LIST;
    }

    @Override
    public List<R> getResult() {
        if (!isRunning) {
            throw new RuntimeException(this.taskName() + " task is not running");
        }
        if (this.result != null && !this.result.isEmpty()) {
            return this.result;
        }
        this.result = this.getAllTask().stream().map(task -> {
            try {
                return task.get();
            } catch (Exception e) {
                log.error("{} task execute fail.", this.taskName(), e);
            }
            return null;
        }).filter(Objects::nonNull).flatMap(Collection::stream).collect(Collectors.toList());
        return this.result;
    }

    @Override
    public void execute(ExecutorService executor) {
        if (isRunning) {
            throw new RuntimeException("task is running.");
        }
        log.info("executor is started task {}", this.taskName());
        //分配组任务
        assignGroupTasks(this.finishedGroupList);
        this.getAllTask().forEach(executor::execute);
    }

    @Override
    public String taskName() {
        return this.taskName;
    }
}
