package com.best.practice.myplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.best.practice.myplus.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


public interface UserMapper extends BaseMapper<User> {

    Map<String, Integer> selectUserCount();

}
