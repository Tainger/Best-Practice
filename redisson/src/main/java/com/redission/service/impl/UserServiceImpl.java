package com.redission.service.impl;

import com.redission.model.entity.User;
import com.redission.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author jiazhiyuan
 * @date 2022/5/22 10:05 上午
 */

@Service
@CacheConfig(cacheNames = {"user_cache"})
public class UserServiceImpl implements UserService {

    @Override
    @Cacheable(key = "#id")
    public User getById(Long id) {
        System.out.println("模拟去db查询");
        User user = new User();
        user.setName("jia");
        user.setId(3l);
        return user;
    }
}



    
