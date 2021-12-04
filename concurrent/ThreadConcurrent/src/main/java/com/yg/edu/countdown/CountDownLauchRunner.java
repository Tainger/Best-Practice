package com.yg.edu.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author jiazhiyuan
 * @date 2021/11/13 6:21 下午
 */
public class CountDownLauchRunner {

    public static void main(String[] args) throws InterruptedException {

        long now = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);


        new Thread(new SeeDoctorTask(countDownLatch)).start();
        new Thread(new QueueTask(countDownLatch)).start();

        //todo see doctor

        countDownLatch.await();
        System.out.println("cover, 回家 cost："+ (System.currentTimeMillis() - now));

    }


    static class  SeeDoctorTask  implements   Runnable {

        private CountDownLatch countDownLatch;

        public SeeDoctorTask(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("妇科检查完毕");
            countDownLatch.countDown();
        }
    }

    static class  QueueTask  implements   Runnable {
        private CountDownLatch countDownLatch;

        public QueueTask(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("拿药完毕");
            countDownLatch.countDown();
            System.out.println(666);

        }
    }
}



    
