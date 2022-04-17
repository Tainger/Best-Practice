package com.best.practice.beaninit;

import com.best.practice.annotation.TaskType;
import com.best.practice.bean.RegisterTaskProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiazhiyuan
 * @date 2022/4/16 5:38 下午
 */

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    private final Map<Integer, RegisterTaskProcessor> registerContext = new ConcurrentHashMap();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof RegisterTaskProcessor) {

            TaskType annotation = bean.getClass().getAnnotation(TaskType.class);
            if(null != annotation) {
                int type = annotation.type();
                RegisterTaskProcessor registerTaskProcessor = (RegisterTaskProcessor) bean;
                registerContext.put(type, registerTaskProcessor);
                System.out.println(registerContext);
            }

        }
        return bean;
    }


    public Map<Integer, RegisterTaskProcessor> getRegisterContext() {
        return registerContext;
    }

    //定义执行顺序
    @Override
    public int getOrder() {
        return 0;
    }
}



    
