package com.netty.base.splitpacket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author jiazhiyuan
 * @date 2021/11/12 1:13 下午
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MyMessageProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyMessageProtocol msg) throws Exception {

        System.out.println("======服务端接收到消息如下=====");
        System.out.println("长度=" + msg.getLen());
        System.out.println("长度=" + new String(msg.getContent(), CharsetUtil.UTF_8));

        System.out.println("服务端接收到消息包数量=" + (++this.count));
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}



    
