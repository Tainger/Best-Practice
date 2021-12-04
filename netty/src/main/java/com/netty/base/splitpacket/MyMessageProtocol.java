package com.netty.base.splitpacket;

import java.util.Arrays;

/**
 *
 * 定义消息头协议
 * @author jiazhiyuan
 * @date 2021/11/12 1:17 下午
 */
public class MyMessageProtocol {

    //定义一次发送包体长度
    private int len;

    //一次发送包体内容
    private byte[] content;


    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyMessageProtocol{" +
                "len=" + len +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}



    
