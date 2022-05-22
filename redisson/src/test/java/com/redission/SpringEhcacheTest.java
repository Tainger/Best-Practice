package com.redission;

import com.redission.model.entity.User;
import com.redission.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author jiazhiyuan
 * @date 2022/5/21 7:13 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-ehcache.xml"})
public class SpringEhcacheTest {

    @Resource
    private CacheManager cacheManager;

    @Resource
    private UserService userService;


    @Test
    public void test1() {
        Cache userCache = cacheManager.getCache("user_cache");
        User user = new User();

        user.setId(1L);
        user.setName("贾志远");

        userCache.put(user.getId(), user);
        User userResult = userCache.get(user.getId(), User.class);

        System.out.println(userResult);

    }


    @Test
    public void test2() {

        User user = userService.getById(3l);
        User user1 = userService.getById(3l);
        User user2 = userService.getById(3l);
        User user3= userService.getById(3l);
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

    }
}



    
