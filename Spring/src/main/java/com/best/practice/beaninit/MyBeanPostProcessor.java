package com.best.practice.beaninit;

import com.best.practice.annotation.TaskType;
import com.best.practice.bean.RegisterTaskProcessor;
import com.best.practice.context.UserContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * @author jiazhiyuan
 * @date 2022/4/16 5:38 下午
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Autowired
   private UserContext userContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof RegisterTaskProcessor) {

            TaskType annotation = bean.getClass().getAnnotation(TaskType.class);
            if(null != annotation) {
                Map<Integer, RegisterTaskProcessor> registerContext = userContext.getRegisterContext();
                int type = annotation.type();
                RegisterTaskProcessor registerTaskProcessor = (RegisterTaskProcessor) bean;
                registerContext.put(type, registerTaskProcessor);
                System.out.println(registerContext);
            }

        }
        return bean;
    }



    //定义执行顺序
    @Override
    public int getOrder() {
        return 0;
    }
}



    
