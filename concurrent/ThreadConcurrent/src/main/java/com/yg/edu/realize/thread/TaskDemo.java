package com.yg.edu.realize.thread;

/**
 * @author jiazhiyuan
 * @date 2021/10/31 5:53 下午
 */
public class TaskDemo implements Runnable{


    public static void main(String[] args) {

        TaskDemo taskDemo = new TaskDemo();

        Thread thread = new Thread(taskDemo);
        thread.start();



    }


    @Override
    public void run() {
        System.out.println("线程执行");
    }
}



    
