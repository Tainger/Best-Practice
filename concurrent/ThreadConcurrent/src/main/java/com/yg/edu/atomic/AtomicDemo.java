package com.yg.edu.atomic;

import com.yg.edu.varhandle.M;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author jiazhiyuan
 * @date 2021/10/29 11:29 下午
 */
public class AtomicDemo {


    private static MyObject myObject = new MyObject();

    static class MyObject{
        public MyObject(){

        }
    }

    /**
     * java代码查看对象头和锁状态
     *         <dependency>
     *             <groupId>org.openjdk.jol</groupId>
     *             <artifactId>jol-core</artifactId>
     *             <version>0.9</version>
     *         </dependency>
     */
    @Test
    public void testAtomicBoolean() {

        System.out.println("当前MAIN线程开始：" + Thread.currentThread().getName() + "---" + ClassLayout.parseInstance(myObject).toPrintable());
        AtomicBoolean atomicBoolean = new AtomicBoolean();

    }
}



    
