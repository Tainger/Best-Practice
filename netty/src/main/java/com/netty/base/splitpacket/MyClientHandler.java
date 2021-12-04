package com.netty.base.splitpacket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author jiazhiyuan
 * @date 2021/11/12 1:21 下午
 */
public class MyClientHandler extends SimpleChannelInboundHandler<MyMessageProtocol> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyMessageProtocol msg) throws Exception {

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String msg = "你好，我是张三！";

            //创建协议包对象

            MyMessageProtocol messageProtocol = new MyMessageProtocol();
            messageProtocol.setLen(msg.getBytes(CharsetUtil.UTF_8).length);
            messageProtocol.setContent(msg.getBytes(CharsetUtil.UTF_8));

            ctx.writeAndFlush(messageProtocol);
        }
    }
}



    
