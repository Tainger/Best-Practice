package com.code.stringDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiazhiyuan
 * @date 2021/11/24 6:59 下午
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        String abc = "123";

        String abc1 = new String("123");

        System.out.println(abc == abc1);

        String abc2 = new String("123");


        System.out.println(abc2 == abc1);

        Map<String, String> map = new ConcurrentHashMap<>();


        Lock lock = new ReentrantLock();


        lock.lock();


        lock.tryLock();

        lock.tryLock(1000, TimeUnit.MILLISECONDS);

        lock.lockInterruptibly();
    }
}



    
