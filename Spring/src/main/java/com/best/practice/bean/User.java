package com.best.practice.bean;

import org.springframework.stereotype.Component;

/**
 * @author jiazhiyuan
 * @date 2022/4/16 6:09 下午
 */

@Component
public class User {

    private String userName = new String("hahaha");

    private Integer age = 10;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}



    
