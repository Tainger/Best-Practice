package com.best.practice;

import com.best.practice.bean.RegisterTaskProcessor;
import com.best.practice.bean.User;
import com.best.practice.beaninit.MyBeanPostProcessor;
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
    private MyBeanPostProcessor myBeanPostProcessor;

    @Test()
    public void testContext() {
        Map<Integer, RegisterTaskProcessor> registerContext = myBeanPostProcessor.getRegisterContext();

        for (Map.Entry<Integer, RegisterTaskProcessor> integerRegisterTaskProcessorEntry : registerContext.entrySet()) {
            RegisterTaskProcessor registerTaskProcessor = integerRegisterTaskProcessorEntry.getValue();

            registerTaskProcessor.register();
            registerTaskProcessor.doCall();
        }
//        user.getAge();
//        System.out.println(user.getUserName());
    }
}
