package com.thread.producerandconcusumer;

/**
 * @author jiazhiyuan
 * @date 2021/10/17 2:56 下午
 */
public class Producer implements Runnable {

    private volatile Integer ticket;


    private final Object lock;

    public Producer(Integer ticket, Object lock) {
        this.ticket = ticket;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket++;
                System.out.println("生产者： " + Thread.currentThread().getName() + "   生产了一个票，目前的票数：" + ticket);
                if (ticket > 0) {
                    lock.notifyAll();
                }
                if (ticket > 10) {

                    System.out.println("生产者： " + Thread.currentThread().getName() + "   满了：" + ticket);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}



    
