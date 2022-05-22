package com.redission;


import com.redission.model.entity.User;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedissionApplication.class)
public class RedissionApplicationTest {

    public static final Logger logger = LoggerFactory.getLogger(RedissionApplicationTest.class);


    @Autowired
    private RedissonClient redissonClient;




    @Test
    public void test() {

        System.out.println(redissonClient);
    }


    @Test
    public void test2() {

        //定义配置文件
        String absPath = "/Users/rocky/Desktop/bestpractice/Best-Practice/redisson/src/main/resources/ehcache.xml";

        //创建缓存
        CacheManager cacheManager = CacheManager.create(absPath);

        String[] cacheNames = cacheManager.getCacheNames();
        logger.info("test2: {}", Arrays.toString(cacheNames));

        Cache userCache = cacheManager.getCache("user_cache");

        //向userCache 放入一个user

        User user = new User();

        user.setId(1L);
        user.setName("贾志远");

        Element element = new Element(user.getId(), user);
        userCache.put(element);

        //通过key 取出缓存的对象
        Element resultEle = userCache.get(1L);
        System.out.println("获取到的resultEle：" + resultEle);
        System.out.println("获取到的resultEle：" + resultEle.getObjectValue());





        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();




    }


}