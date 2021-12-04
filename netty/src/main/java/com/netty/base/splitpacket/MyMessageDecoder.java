package com.netty.base.splitpacket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author jiazhiyuan
 * @date 2021/11/12 1:11 下午
 */
public class MyMessageDecoder extends ByteToMessageDecoder {

    int length = 0;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println();

        System.out.println("MyMessageDecoder decode 被调用");

        System.out.println(in);

        if(in.readableBytes() >= 4) {
            if(length == 0) {
                //可读的内存大小
                length = in.readInt();
            }

            if(in.readableBytes() < length) {
                System.out.println("当前读数据不够，继续等待");
                return;
            }

            byte[] content = new byte[length];
            if(in.readableBytes() >= length) {
                in.readBytes(content);
                //封装成MyMessageProtocal对象，传递到下一个handler业务处理
                MyMessageProtocol messageProtocol = new MyMessageProtocol();
                messageProtocol.setLen(length);
                messageProtocol.setContent(content);
                out.add(messageProtocol);
            }
            length = 0;

        }
    }
}



    
