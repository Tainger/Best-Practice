package com.redission;

import com.redission.model.entity.User;
import com.redission.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest(classes = RedissionApplication.class)
public class SpringBootEhcacheTest {

    @Resource
    private CacheManager cacheManager;

    @Resource
    private UserService userService;


    /*
    *
    * 1. 在yaml 文件中配置eacheCache 缓存
    *
    * 2. enable Caching 注解
    * */
    @Test
    public void test1() {

        System.out.println(cacheManager.getClass());

//        User user = userService.getById(33L);
//        System.out.println(user);
//        System.out.println(userService.getById(33L));
//        System.out.println(userService.getById(33L));

    }
}



    
