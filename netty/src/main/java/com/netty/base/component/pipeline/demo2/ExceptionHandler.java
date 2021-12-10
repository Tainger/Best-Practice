package com.netty.base.component.pipeline.demo2;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author jiazhiyuan
 * @date 2021/12/7 10:35 下午
 */
public class ExceptionHandler extends ChannelDuplexHandler {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        if (cause instanceof RuntimeException) {
            System.out.println("Handle Business Exception Success.");
        }
    }
}



    
