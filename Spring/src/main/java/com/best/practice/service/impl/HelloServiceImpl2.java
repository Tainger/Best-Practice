package com.best.practice.service.impl;

import com.best.practice.service.HelloService;

/**
 * @author jiazhiyuan
 * @date 2022/4/16 6:03 下午
 */
public class HelloServiceImpl2 implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("你好我是HelloServiceImpl2");
    }

    @Override
    public String testNotNull() {
        return null;
    }
}



    
