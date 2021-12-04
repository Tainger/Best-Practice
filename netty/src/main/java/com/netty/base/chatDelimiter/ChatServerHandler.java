package com.netty.base.chatDelimiter;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiazhiyuan
 * @date 2021/11/11 11:27 下午
 * 自定义Handler需要继承netty规定好的某个HandlerAdapter规范
 */
public class ChatServerHandler extends SimpleChannelInboundHandler {


    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //Channel channel = ctx.channel();
        //ChannelPipeline pipeline = ctx.pipeline(); //本质是一个双向链接, 出站入站
        //将 msg 转成一个 ByteBuf，类似NIO 的 ByteBuffer
        Channel channel = ctx.channel();
        String msg2 = "客户端" + channel.remoteAddress() + "发送消息是:" +msg +"_";
//        channelGroup.forEach(ch -> {
//            if(channel != ch) {
//                ch.writeAndFlush(msg2 );
//            }else {
//                ch.writeAndFlush(msg2);
//            }
//        });
        channelGroup.writeAndFlush(msg2);
        System.out.println(msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该客户加入聊天的信息推送给其他在线客户端
        //该方法会将channelGroup 中所有的channel 遍历，并发送消息

        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress()
                + "上线了" + simpleDateFormat.format(new Date()) + "\n");

        channelGroup.add(channel);

        System.out.println(ctx.channel().remoteAddress() + "上线了" + "\n");



    }

    /**
     * 75 * 数据读取完毕处理方法
     * 76 *
     * 77 * @param ctx
     * 78 * @throws Exception
     * 79
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //todo
    }

    /**
     *  处理异常, 一般是需要关闭通道
     *
     *   @param ctx
     *  @param cause
     *  @throws Exception
     *
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}



    
