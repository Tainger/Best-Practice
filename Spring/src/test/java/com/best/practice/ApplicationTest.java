package com.best.practice;

import com.best.practice.bean.RegisterTaskProcessor;
import com.best.practice.bean.User;
import com.best.practice.beaninit.MyBeanPostProcessor;
import com.best.practice.context.UserContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Autowired
    private UserContext userContext;

    @Test()
    public void testContext() {
        Map<Integer, RegisterTaskProcessor> registerContext = userContext.getRegisterContext();
        System.out.println(registerContext);
    }
}
