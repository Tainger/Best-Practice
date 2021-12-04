package com.yg.edu.readAndWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiazhiyuan
 * @date 2021/10/31 1:14 下午
 */
public class Cache <K, V>{

    final Map<K, V> m = new HashMap<>();

    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


}



    
