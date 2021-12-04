package com.yg.edu.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiazhiyuan
 * @date 2021/10/31 10:45 下午
 */
public class RetrantLockDemo {

    private int count;

    private Lock lock = new ReentrantLock();


    public void add() {
        for (int i = 0; i < 100000; i++) {
            lock.lock();
            count++;
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "....." + count);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        RetrantLockDemo retrantLockDemo = new RetrantLockDemo();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(retrantLockDemo::add);
            thread.start();
        }

    }

}



    
