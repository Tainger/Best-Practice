package com.best.practice;

import com.best.practice.bean.RegisterTaskProcessor;
import com.best.practice.bean.User;
import com.best.practice.beaninit.MyBeanPostProcessor;
import com.best.practice.context.UserContext;
import com.best.practice.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Halo main class.
 *
 * @author ryanwang
 * @date 2017-11-14
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {



    @Autowired(required = true)
    private User user;

    @Resource
    private HelloService helloService;

    @Test()
    public void testContext() {

    }


    @Test()
    public void testContext2() {
        helloService.testNotNull();
    }
}
