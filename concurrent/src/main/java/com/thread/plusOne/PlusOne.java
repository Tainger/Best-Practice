package com.thread.plusOne;

/**
 * @author jiazhiyuan
 * @date 2021/10/17 4:07 下午
 */
public class PlusOne implements Runnable{

    private  int count = 0;
    @Override
    public void run() {

        while (count < 1000){
            count ++;
            System.out.println(Thread.currentThread().getName() + "..." + count);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        PlusOne plusOne = new PlusOne();
        Thread  thread = new Thread(plusOne);
        thread.setName("线程");
        thread.start();

        Thread  thread2 = new Thread(plusOne);
        thread2.setName("线程2");
        thread2.start();

        thread.join();
        thread2.join();
        System.out.println(plusOne.count);
    }
}



    
