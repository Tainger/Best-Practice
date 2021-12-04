package com.netty.base.splitpacket;

import com.netty.base.chat.ClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author jiazhiyuan
 * @date 2021/11/12 2:21 下午
 */
public class MyClient {


    public static void main(String[] args) throws InterruptedException {


        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {
                ChannelPipeline pipeline = channel.pipeline();
                pipeline.addLast(new MyMessageEncoder());
                pipeline.addLast(new MyClientHandler());
            }
        });

        System.out.println("netty client start");

        //启动客户端去连接服务器端
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9000).sync();
        Channel channel = channelFuture.channel();
        System.out.println("========" + channel.localAddress() + "======");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            //通过channel 发送到服务器端
            channel.writeAndFlush(msg);
        }
//            //对关闭通道进行监听
//            channelFuture.channel().closeFuture().sync();
    }
}



    
