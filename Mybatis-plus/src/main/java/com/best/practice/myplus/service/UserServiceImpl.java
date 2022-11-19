package com.best.practice.myplus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.best.practice.myplus.mapper.UserMapper;
import com.best.practice.myplus.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author jiazhiyuan
 * @date 2022/2/6 9:44 下午
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {




}



    
