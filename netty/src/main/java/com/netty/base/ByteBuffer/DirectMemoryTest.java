package com.netty.base.ByteBuffer;

import java.nio.ByteBuffer;

/**
 * @author jiazhiyuan
 * @date 2021/11/21 1:46 下午
 */
public class DirectMemoryTest {



    public static  void heapAccess() {
        long startTime = System.currentTimeMillis();
        //分配堆内存
        ByteBuffer buffer = ByteBuffer.allocate(10000);
        for(int i = 0; i < 100000; i ++) {

            for(int j = 0; j < 2000; j++) {
                buffer.putInt(j);
            }
            buffer.flip();
            for (int j = 0; j < 2000; j ++) {
                buffer.getInt();
            }
            buffer.clear();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("堆内存访问：" + (endTime - startTime) + "ms");
    }

    public static  void directAccess() {
        long startTime = System.currentTimeMillis();
        //分配堆内存
        ByteBuffer buffer = ByteBuffer.allocateDirect(10000);
        for(int i = 0; i < 100000; i ++) {

            for(int j = 0; j < 2000; j++) {
                buffer.putInt(j);
            }
            buffer.flip();
            for (int j = 0; j < 2000; j ++) {
                buffer.getInt();
            }
            buffer.clear();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("直接内存访问：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        heapAccess();
        directAccess();


    }

}



    
