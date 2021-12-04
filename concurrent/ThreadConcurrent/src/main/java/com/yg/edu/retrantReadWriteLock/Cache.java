package com.yg.edu.retrantReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiazhiyuan
 * @date 2021/10/28 12:17 上午
 */
public class Cache<K, V> {

    final Map<K, V> m = new HashMap<>();

    final ReadWriteLock  readWriteLock= new ReentrantReadWriteLock();
}



    
