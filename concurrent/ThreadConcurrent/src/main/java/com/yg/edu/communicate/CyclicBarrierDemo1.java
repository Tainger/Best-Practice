package com.yg.edu.communicate;

import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jiazhiyuan
 * @date 2021/10/25 9:37 下午
 */
public class CyclicBarrierDemo1 {


    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

      new Thread(new Runnable() {
          @Override
          public void run() {
              try {
                  Thread.sleep(2000);
                  System.out.println("2000");
                  cyclicBarrier.await();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              } catch (BrokenBarrierException e) {
                  e.printStackTrace();
              }

          }
      }).start();

      cyclicBarrier.await();


        System.out.println("6666");
    }
}



    
