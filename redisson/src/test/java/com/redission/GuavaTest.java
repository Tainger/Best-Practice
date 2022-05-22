package com.redission;

import com.google.common.cache.*;
import com.redission.model.entity.User;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author jiazhiyuan
 * @date 2022/5/22 11:25 上午
 */
public class GuavaTest {



    @Test
    public void test() throws InterruptedException {

        LoadingCache<Long, User> loadingCache = (LoadingCache<Long, User>) CacheBuilder.newBuilder()
                //并发级别8
                .concurrencyLevel(8)
                //初始大小，配合concurencyLevel 做分段锁
                .initialCapacity(60)
                //缓存最多可放多少个元素
                .maximumSize(20)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                //统计命中率
                .recordStats()
                .removalListener(new RemovalListener<Long, User>() {
                    @Override
                    public void onRemoval(RemovalNotification<Long, User> notification) {
                        Long key = notification.getKey();
                        RemovalCause cause = notification.getCause();
                        System.out.println("key:" + key +"被移除缓存的原因：" + cause);
                    }
                })
                .build(new CacheLoader<Long, User>() {
                    @Override
                    public User load(Long aLong) throws Exception {
                        System.out.println("去db加载");
                        User user = new User();
                        user.setId(33L);
                        user.setName("jia");
                        return user;
                    }
                });


        for (int i = 0; i < 20; i++) {
            User user = loadingCache.getUnchecked(33L);
            System.out.println(user);

            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(loadingCache.stats().toString());
    }
}



    
