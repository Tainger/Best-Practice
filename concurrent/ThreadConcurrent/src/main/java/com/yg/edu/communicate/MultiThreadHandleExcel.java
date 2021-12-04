package com.yg.edu.communicate;

/**
 * @author jiazhiyuan
 * @date 2021/10/25 9:13 下午
 */
public class MultiThreadHandleExcel {


    public static void main(String[] args) throws InterruptedException {



        Thread thread = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("excel1 完成");
        });

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("excel2 完成");
        });


        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println("完成");
    }
}



    
