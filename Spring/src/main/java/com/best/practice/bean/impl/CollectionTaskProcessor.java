package com.best.practice.bean.impl;

import com.best.practice.annotation.TaskType;
import com.best.practice.bean.AbstractRegisterTaskProcessor;
import com.best.practice.bean.RegisterTaskProcessor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author jiazhiyuan
 * @date 2022/4/16 6:18 下午
 */

@TaskType(type = 3)
public class CollectionTaskProcessor extends AbstractRegisterTaskProcessor {

    @Value("${test.collection-executor}")
    private Integer executorId;


    @Override
    public Integer getExecutorId() {
        return executorId;
    }

    @Override
    public void call() {
        System.out.println("数据集任务被执行了");
    }
}



    
