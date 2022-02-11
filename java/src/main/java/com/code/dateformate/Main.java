package com.code.dateformate;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author jiazhiyuan
 * @date 2022/1/27 2:13 下午
 */


@Slf4j
public class Main {

    private final  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //    private final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 100, 1,
//            TimeUnit.MINUTES, new LinkedBlockingQueue<>(1000), new MyThreadFactory("SimpleDateFormatTest"));
    private final static Executor executor = Executors.newFixedThreadPool(10);


    public static void main(String[] args) {

//        while (true) {
//            executor.execute(() -> {
//                Date date = new Date();
//                String dateformate = simpleDateFormat.format(date);
//                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String dateformate2 = simpleDateFormat2.format(date);
//                if (!dateformate.equals(dateformate2)) {
//                    log.info("线程：{}, failure", Thread.currentThread().getName());
//                }
//            });
//        }
        ThreadFacory threadFacory = new ThreadFacory();
        threadFacory.main();
    }
}



    
