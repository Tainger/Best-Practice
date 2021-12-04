package com.yg.edu.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jiazhiyuan
 * @date 2021/11/13 7:15 下午
 */
public class CyclicBarrierDemo{


    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {


        new Thread(()->{

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程 方法已经到达终点");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }


            System.out.println("线程 开跑");
        }).start();


        System.out.println("main 方法已经到达终点");
        cyclicBarrier.await();

        System.out.println("main 开跑");



    }
}



    
