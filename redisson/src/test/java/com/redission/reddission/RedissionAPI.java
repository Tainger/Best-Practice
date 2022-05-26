package com.redission.reddission;

import com.google.common.base.Joiner;
import com.redission.RedissionApplication;
import com.redission.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.*;
import org.redisson.api.map.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author jiazhiyuan
 * @date 2022/5/24 1:10 下午
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedissionApplication.class)
public class RedissionAPI {

    private static final Logger logger = LoggerFactory.getLogger(RedissionAPI.class);

    @Autowired
    private RedissonClient redissonClient;


    private Integer maxSize = 10;


    @Test
    public void test() throws InterruptedException {
//        RDeque<Object> deque = redissonClient.getDeque("jiazhiyuan");
        RMapCache<Object, Object> cache = redissonClient.getMapCache("cache");

        registerListener(cache);
//        deque.addFirst("user1");
//        cache.put("user1", "data", 1000, TimeUnit.SECONDS);
//        deque.addFirst("user3");
//        cache.put("user3", "data", 1000, TimeUnit.SECONDS);
//        deque.addFirst("user4");
//        cache.put("user4", "data", 1000, TimeUnit.SECONDS);
//        deque.addFirst("user5");
//        cache.put("user5", "data", 1000, TimeUnit.SECONDS);
//        logger.info("deque: {}", deque.readAll());

//        logger.info("cache: {}", cache.get("user1"));
//        logger.info("cache: {}", cache.get("user3"));
//        logger.info("cache: {}", cache.get("user4"));
//        logger.info("cache: {}", cache.get("user5"));
        cache.setMaxSize(10, EvictionMode.LRU);
        String user = "user";
        Set<Object> keySet = new HashSet<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 110; i++) {
            UUID uuid = UUID.randomUUID();
            String substring = uuid.toString().substring(0, 5);
            cache.put(substring, "data", 1000, TimeUnit.SECONDS);
            keySet.add(substring);
            stringList.add(substring);
            Thread.sleep(100);
        }


        logger.info("加入过程：{}", Joiner.on(",").join(stringList));
        logger.info("缓存：{}", cache.getAll(keySet));

    }

    private void registerListener(RMapCache<Object, Object> cache) {
        int updateListener = cache.addListener(new EntryUpdatedListener<String, String>() {
            @Override
            public void onUpdated(EntryEvent<String, String> event) {
                String key = event.getKey();
                String value = event.getValue();
                String oldValue = event.getOldValue();
                logger.info("{} 更新, {}, {}", key, value, oldValue);
            }
        });

        int createListener = cache.addListener(new EntryCreatedListener<String, String>() {
            @Override
            public void onCreated(EntryEvent<String, String> event) {
                String key = event.getKey();
                String value = event.getValue();
                String oldValue = event.getOldValue();
                logger.info("{} 创建, {}, {}", key, value, oldValue);

            }
        });

        int expireListener = cache.addListener(new EntryExpiredListener<String, String>() {
            @Override
            public void onExpired(EntryEvent<String, String> event) {
                String key = event.getKey();
                String value = event.getValue();
                String oldValue = event.getOldValue();
                logger.info("{} 过期了, {}, {}", key, value, oldValue);

            }
        });

        int removeListener = cache.addListener(new EntryRemovedListener<String, String>() {
            @Override
            public void onRemoved(EntryEvent<String, String> event) {
                String key = event.getKey();
                String value = event.getValue();
                String oldValue = event.getOldValue();
                logger.info("{} 移除, {}, {}", key, value, oldValue);

            }
        });

//        int removeListener = cache.addListener(new MapEntryListener() {
//            @Override
//            public void onRemoved(EntryEvent<String, String> event) {
//                String key = event.getKey();
//                String value = event.getValue();
//                String oldValue = event.getOldValue();
//                logger.info("{} 移除, {}, {}", key, value, oldValue);
//
//            }
//        });

    }


    private void put(Object key, Object value) {
        RDeque<Object> deque = redissonClient.getDeque("jiazhiyuan");
        if (deque.size() >= maxSize) {
            boolean result = deque.contains(key);
            if (result) {
                logger.info("存在了key");
            }
            if (!result) {
                Object o = deque.removeLast();
                logger.info("移除最后一个{}", o);
            }

        }
        //加入
        RMapCache<Object, Object> cache = redissonClient.getMapCache("cache");
        cache.put(key, value, 1000, TimeUnit.SECONDS);
    }


    private void get(Object key) {
        RDeque<Object> deque = redissonClient.getDeque("jiazhiyuan");
        if (deque.size() >= maxSize) {
            boolean result = deque.contains(key);
            if (result) {
                logger.info("存在了key");
            }
            if (!result) {
                Object o = deque.removeLast();
                logger.info("移除最后一个{}", o);
            }

        }
        //加入
        RMapCache<Object, Object> cache = redissonClient.getMapCache("cache");
//        cache.setMaxSize();
    }


    @Test
    public void test2() {

        List<User> userList = new ArrayList<>(100000);

        for (int i = 0; i < 100000; i++) {

            User user = new User();
            user.setName("贾志远");
            user.setId(2l);
            userList.add(user);
        }

        try {
            RMapCache<String, List<User>> map = redissonClient.getMapCache("测试容量map");

            // 尝试将该映射的最大容量限制设定为10
            map.trySetMaxSize(10000);
            // 将该映射的最大容量限制设定或更改为10
            map.setMaxSize(10000);
            for (int i = 0; i < 10000; i++) {
                logger.info("第{}个", i);
                map.put(String.valueOf(i), userList, 30, TimeUnit.MINUTES);
            }
        } catch (Exception e) {
            logger.info("redis客户端操作失败，异常信息：", e);
        }


    }


    @Test
    public void tes3() {

        RMapCache<String, List<User>> map = redissonClient.getMapCache("测试容量map");
        for (int i = 0; i < 200000; i++) {
            List<User> userList = map.get(String.valueOf(i));
            System.out.println(userList);
        }

    }
}



    
