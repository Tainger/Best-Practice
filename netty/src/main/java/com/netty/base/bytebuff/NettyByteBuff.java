package com.netty.base.bytebuff;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author jiazhiyuan
 * @date 2021/11/12 1:02 上午
 */
public class NettyByteBuff {

    //创建byteBuf对象，该对象内部包含一个字节数组byte[10]
    //通过readerindex 和 writerindex 和 capacity，将buffer 分成三个区域
    //已经读取的区域：[0, readerIndex]
    //可读取的区域[readerindex, writerIndex）
    //可写的区域：[writerIndex, capacity)


    public static void main(String[] args) {
        ByteBuf  byteBuf = Unpooled.buffer(10);
        System.out.println("byteBuf=" + byteBuf);


        for(int i = 0; i < 8; i ++) {
            byteBuf.writeByte(i);
        }
        System.out.println("byteBuf= " + byteBuf);

        for(int i = 0; i < 5; i ++) {
            System.out.println(byteBuf.getByte(i));
        }
        System.out.println("byteBuf= " + byteBuf);

        for(int i = 0; i < 5; i ++) {
            System.out.println(byteBuf.readerIndex(i));
        }
        System.out.println("byteBuf= " + byteBuf);

    }






}



    
