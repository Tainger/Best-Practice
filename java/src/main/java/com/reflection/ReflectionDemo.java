package com.reflection;

import java.lang.reflect.Field;

/**
 * @author jiazhiyuan
 * @date 2022/2/17 3:11 下午
 */
public class ReflectionDemo {


    private Integer code;
    private String name;
    private Integer age;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "ReflectionDemo{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public static void main(String[] args) {

//        ReflectionDemo reflectionDemo = new ReflectionDemo();
//        reflectionDemo.setAge(13);
//        reflectionDemo.setName();
//        Field[] fields = reflectionDemo.getClass().getFields();


    }
}



    
