package com.netty.base.io.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;

/**
 * @author jiazhiyuan
 * @date 2021/12/9 12:46 上午
 */
public class ChannelDemo {

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("////");
        FileChannel channel = fileOutputStream.getChannel();
    }
}



    
