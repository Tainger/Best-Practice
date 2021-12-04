package com.yg.edu.communicate;

import lombok.SneakyThrows;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author jiazhiyuan
 * @date 2021/10/25 10:14 下午
 */
public class SemaphoreDemo {

    private static final  int THREAD_COUNT = 30;


    private static Executor executor = Executors.newFixedThreadPool(4);


    private static Semaphore semaphore = new Semaphore(10);


    public static void main(String[] args) {

        for (int i = 0; i < THREAD_COUNT; i++) {

            executor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    semaphore.acquire();
                    System.out.println("拿到了一个连接");
                    semaphore.release();
                }
            });


        }

        System.out.println("end");
    }


}



    
