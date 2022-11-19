package com.best.practice.service.impl;

import com.best.practice.service.HelloService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author jiazhiyuan
 * @date 2022/4/16 6:02 下午
 */

@Service
public class HelloServiceImpl1 implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("你好我是HelloServiceImpl1");
    }

    @Override
    public @NotNull String testNotNull() {
        return null;
    }
}



    
