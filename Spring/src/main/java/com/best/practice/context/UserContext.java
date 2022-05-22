package com.best.practice.context;

import com.best.practice.bean.RegisterTaskProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiazhiyuan
 * @date 2022/4/17 11:00 下午
 */
@Component
public class UserContext {

    private final Map<Integer, RegisterTaskProcessor> registerContext = new ConcurrentHashMap();

    public Map<Integer, RegisterTaskProcessor> getRegisterContext() {
        return registerContext;
    }

}



    
