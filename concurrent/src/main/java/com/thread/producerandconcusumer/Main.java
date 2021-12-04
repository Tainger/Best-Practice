package com.thread.producerandconcusumer;

/**
 * @author jiazhiyuan
 * @date 2021/10/17 3:05 下午
 */
public class Main {

    public static void main(String[] args) {
        int ticket = 0;

        Object lock = new Object();
        Producer producer = new Producer(ticket, lock);

        Thread thread = new Thread(producer);
        thread.start();

        Consumer consumer = new Consumer(ticket, lock);

        Thread thread2 = new Thread(consumer);
        thread2.start();
    }
}



    
