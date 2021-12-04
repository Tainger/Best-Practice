package com.yg.edu.synchronize;

import org.junit.Test;

/**
 * @author jiazhiyuan
 * @date 2021/11/7 6:03 下午
 */
public class SynchronizedDemo {


    @Test
    public void testSynchronizedSupportInterrupt() {


        Thread thread = new Thread(this::init, "线程2");
        thread.start();



    }

    public  synchronized void init(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



    
