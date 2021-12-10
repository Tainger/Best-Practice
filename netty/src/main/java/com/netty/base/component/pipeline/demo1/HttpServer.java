package com.netty.base.component.pipeline.demo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author jiazhiyuan
 * @date 2021/12/7 10:17 下午
 */
public class HttpServer {

    public void start(int port) throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new SampleInBoundHandler("SampleInBoundHandlerA", false))
                                    .addLast(new SampleInBoundHandler("SampleInBoundHandlerB", false))
                                    .addLast(new SampleInBoundHandler("SampleInBoundHandlerC", true));
                            ch.pipeline()
                                    .addLast(new SampleOutBoundHandler("SampleOutBoundHandlerA"))
                                    .addLast(new SampleOutBoundHandler("SampleOutBoundHandlerB"))
                                    .addLast(new SampleOutBoundHandler("SampleOutBoundHandlerC"));
                        }
                    }).childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            System.out.println("Http Server started, Listening on" + port);
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new HttpServer().start(8088);
    }
}



    
