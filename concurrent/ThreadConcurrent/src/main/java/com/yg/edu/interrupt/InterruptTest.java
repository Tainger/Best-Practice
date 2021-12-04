package com.yg.edu.interrupt;

import org.junit.Test;

/**
 * @author jiazhiyuan
 * @date 2021/11/2 9:53 下午
 */
public class InterruptTest {


    /**
     * 模拟线程中断
     */
    @Test
    public void testInterrupt() throws InterruptedException {
        InterruptDemo interruptDemo = new InterruptDemo();
        interruptDemo.show();


    }
}



    
