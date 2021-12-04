package com.thread.producerandconcusumer;

/**
 * @author jiazhiyuan
 * @date 2021/10/17 2:57 下午
 */
public class Consumer implements Runnable{

    private  int ticket;


    private final Object lock;

    public Consumer(Integer ticket, Object lock) {
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
                if (ticket < 1) {
                    try {
                        System.out.println("进入阻塞： " + Thread.currentThread().getName() + "   目前的票数：" + ticket);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ticket--;
                lock.notifyAll();
                System.out.println("票被买了： " + Thread.currentThread().getName() + "   目前的票数：" + ticket);
            }

        }

    }
}



    
