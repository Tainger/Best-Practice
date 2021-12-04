package com.yg.edu.realize.thread;

/**
 * @author jiazhiyuan
 * @date 2021/10/31 5:56 下午
 */
public class TaskDemo1  {


    public static void main(String[] args) {

        Thread thread = new Thread(()->{

            System.out.println("线程被调度执行");
        });

        thread.start();
    }
}



    
