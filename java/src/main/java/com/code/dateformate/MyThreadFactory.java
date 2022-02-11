package com.code.dateformate;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiazhiyuan
 * @date 2022/1/27 2:18 下午
 */
public class MyThreadFactory implements ThreadFactory {

    private String factoryName;

    private final static AtomicInteger atomicInteger = new AtomicInteger(0);

    public MyThreadFactory(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public Thread newThread(Runnable r) {
        int num = atomicInteger.incrementAndGet();
        return new Thread(getThreadName(num));
    }

    private String getThreadName(int num) {
        return String.format("%s:%d", factoryName, num);
    }
}



    
