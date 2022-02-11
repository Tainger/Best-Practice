package com.best.practice.myplus;

import com.best.practice.myplus.mapper.UserMapper;
import com.best.practice.myplus.model.entity.User;
import com.best.practice.myplus.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author jiazhiyuan
 * @date 2022/2/6 8:05 下午
 */


@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisPlusDemoApplicationTest {


    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(userList.size(), 5);
        userList.forEach(System.out::println);
    }


    @Test
    public void testUserService() {
        long count = userService.count();
        Assert.assertEquals(count, 5);
        System.out.println(count);
        User user = userService.getById(1);
        user.setName("贾志远");
        user.setId(10L);
        boolean save = userService.save(user);
        user = userService.getById(10L);
        Assert.assertEquals(user.getName(), "贾志远");
    }
}



    
