package com.class_loader;

import java.util.concurrent.locks.Condition;

/**
 * @author jiazhiyuan
 * @date 2022/11/17 11:50 下午
 */
public class ClassLoader01 {

    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try {
            classLoader.loadClass("demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Condition

                Lock
    }
}



    
