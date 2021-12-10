package com.netty.base.component.pipeline.demo2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author jiazhiyuan
 * @date 2021/12/7 10:19 下午
 */
public class SampleInBoundHandler extends ChannelInboundHandlerAdapter {

    private final String name;
    private final boolean flush;

    public SampleInBoundHandler(String name, boolean flush) {
        this.name = name;
        this.flush = flush;
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InBoundHandler: " + name);
        if (flush) {
            ctx.channel().writeAndFlush(msg);
        } else {
            throw new RuntimeException("InBoundHandler: " + name);
        }
    }


    @Override
    @SuppressWarnings("deprecation")
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {

        System.out.println("InBoundHandlerException: " + name);
        ctx.fireExceptionCaught(cause);
    }


}



    
