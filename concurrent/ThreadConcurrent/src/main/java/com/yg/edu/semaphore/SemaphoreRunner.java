package com.yg.edu.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author jiazhiyuan
 * @date 2021/11/13 4:21 下午
 */
public class SemaphoreRunner {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);


        for(int i = 0; i < 10; i++) {

            new Thread(new Task(semaphore, "jiazhiyuan:" + i)).start();
        }
    }

    static class Task extends Thread {

        private Semaphore semaphore;

        public Task(Semaphore semaphore, String name) {
            super(name);
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(2);//获取公共资源
                System.out.println(Thread.currentThread().getName() +": acquire at timme " + System.currentTimeMillis());
                Thread.sleep(5000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



    
