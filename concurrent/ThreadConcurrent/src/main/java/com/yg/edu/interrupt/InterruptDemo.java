package com.yg.edu.interrupt;

/**
 * @author jiazhiyuan
 * @date 2021/11/2 9:54 下午
 */
public class InterruptDemo {


    public void show() throws InterruptedException {

        Thread thread = new Thread(()->{

            try {
                Thread.sleep(5000);
                System.out.println("线程01的中断标志1：" + Thread.currentThread().isInterrupted());
            } catch (InterruptedException e) {
                System.out.println("线程01的中断标志2：" + Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
            System.out.println(666);

        }, "线程01");
        thread.start();


        Thread.sleep(1000);

        System.out.println("线程01的中断标志：" + thread.isInterrupted());
        thread.interrupt();
        System.out.println("线程01的中断标志：" + thread.isInterrupted());

    }
}



    
