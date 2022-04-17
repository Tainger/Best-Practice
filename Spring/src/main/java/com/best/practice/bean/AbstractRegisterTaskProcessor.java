package com.best.practice.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jiazhiyuan
 * @date 2022/4/16 6:43 下午
 */
public abstract class AbstractRegisterTaskProcessor implements RegisterTaskProcessor {


    @Autowired
    private User user;



    @Override
    public void register() {
        Integer executorId = getExecutorId();
        System.out.println(executorId);

        String userName = user.getUserName();
        System.out.println(user.getAge());
    }

    @Override
    public void doCall() {
        call();
    }


    public abstract Integer getExecutorId();


    public abstract void call();
}



    
