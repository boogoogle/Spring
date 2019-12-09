package com.booo.spring.controller;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloNetty {

    @RequestMapping("/netty")
    public void netty() {
        // 定义一对线程组,

        // 主线程组,用于接收客户端的链接,但是不做任何处理. 像老板一样,啥都不做
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 从线程组, 接收主线程组的任务
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // netty服务器的创建, ServerBootStrap是一个启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup) // 设置主从线程组
                    .channel(NioServerSocketChannel.class) // 设置nio的双向通道
                    .childHandler(new ServerInitializer()); // 子处理器,用于处理workerGroup
            // 启动server, 并设置端口号,启动方式为同步
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            // 监听关闭的channel,设置位同步方式
            channelFuture.channel().close().sync();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
