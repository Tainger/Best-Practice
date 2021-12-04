package com.yg.edu.realize.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author jiazhiyuan
 * @date 2021/10/31 5:57 下午
 */
public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                System.out.println("我在操作");
                return "我执行了";
            }
        };

        FutureTask futureTask = new FutureTask(callable);
        System.out.println("我在执行");
        futureTask.run();
        System.out.println("MAIN");
        Object o = futureTask.get();
        System.out.println("MAIN1");
        System.out.println(o);


    }
}



    
