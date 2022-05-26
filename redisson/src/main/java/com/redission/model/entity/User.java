package com.redission.model.entity;

import java.io.Serializable;

/**
 * @author jiazhiyuan
 * @date 2022/5/21 5:07 下午
 */
public class User implements Serializable {

    private Long Id;

    private String name;

    public User(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public User() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}



    
