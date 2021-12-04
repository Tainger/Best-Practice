package com.yg.edu.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author jiazhiyuan
 * @date 2021/11/13 6:42 下午
 */
public class ZookeeperCountDown {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我冲出来了" + Thread.currentThread().getName());
            },"线程" + i).start();


        }
        System.out.println("预备冲");
        countDownLatch.countDown();



    }
}



    
