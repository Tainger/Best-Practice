package com.yg.edu.communicate;

import lombok.SneakyThrows;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author jiazhiyuan
 * @date 2021/10/25 9:52 下午
 */
public class BankWaterService implements Runnable {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);


    private Executor executor = Executors.newFixedThreadPool(4);


    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap();

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> entry : sheetBankWaterCount.entrySet()) {
            result += entry.getValue();
        }
        System.out.println(result);
    }

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    Thread.sleep(2000);
                    System.out.println("完成了");
                    cyclicBarrier.await();
                }
            });
        }
    }


    public static void main(String[] args) {

        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}



    
