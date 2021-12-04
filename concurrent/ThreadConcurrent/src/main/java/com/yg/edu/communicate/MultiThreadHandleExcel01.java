package com.yg.edu.communicate;

import java.util.concurrent.CountDownLatch;

/**
 * @author jiazhiyuan
 * @date 2021/10/25 9:13 下午
 */
public class MultiThreadHandleExcel01 {

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {



        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务一完成");
            countDownLatch.countDown();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务二完成");
            countDownLatch.countDown();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务三完成");
            countDownLatch.countDown();


            countDownLatch.countDown();
        });

        thread.start();
        countDownLatch.await();

        System.out.println("成功了");
    }
}



    
