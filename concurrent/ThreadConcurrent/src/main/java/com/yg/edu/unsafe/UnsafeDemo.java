package com.yg.edu.unsafe;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author jiazhiyuan
 * @date 2021/10/27 11:40 下午
 */
public class UnsafeDemo {


    public static void main(String[] args) {


    }

    @Test
    public void achieveSafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



    
