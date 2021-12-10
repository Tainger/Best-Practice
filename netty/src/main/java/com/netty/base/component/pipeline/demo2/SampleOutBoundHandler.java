package com.netty.base.component.pipeline.demo2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author jiazhiyuan
 * @date 2021/12/7 10:22 下午
 */
public class SampleOutBoundHandler extends ChannelOutboundHandlerAdapter {

    private final String name;

    public SampleOutBoundHandler(String name) {
        this.name = name;
    }


    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        System.out.println("OutBoundHandler: " + name);
        super.write(ctx, msg, promise);
    }


}



    
