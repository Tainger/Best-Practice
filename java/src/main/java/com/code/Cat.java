package com.code;

/**
 * @author jiazhiyuan
 * @date 2021/11/21 9:29 下午
 */
public class Cat extends Animal{

    static {
        System.out.println("Cat  静态代码块");
    }

    public Cat() {
        System.out.println("Cat   构造函数");
    }

    {
        System.out.println("Cat    代码块");
    }
}



    
