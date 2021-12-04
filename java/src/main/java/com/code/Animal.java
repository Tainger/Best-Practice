package com.code;

/**
 * @author jiazhiyuan
 * @date 2021/11/21 9:29 下午
 */
public class Animal {

    static {
        System.out.println("Animal  静态代码块");
    }

    public Animal() {
        System.out.println("Animal   构造函数");
    }

    {
        System.out.println("Animal    代码块");
    }
}



    
