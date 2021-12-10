package com.yg.edu.atomic.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;


public class AtomicIntegerArrayRunner {

    static int[] value = new int[]{1,2};
    static AtomicIntegerArray aiArray = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        //todo 原子修改数组下标0的数值
        aiArray.getAndSet(0,3);
        System.out.println(aiArray.get(0));
        System.out.println(value[0]);
}

}
