package com.best.practice.myplus.configure.listenser;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author jiazhiyuan
 * @date 2022/2/15 11:23 上午
 */
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("事件触发：" + event.getClass().getName());
    }
}



    
