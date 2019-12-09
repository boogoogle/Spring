package com.booo.spring.controller;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Description:初始化, channel注册后, 会执行里面对应的初始化方法
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 获取对应的pipeline
        ChannelPipeline pipeline = socketChannel.pipeline();

        // 通过管道添加handler
        // HttpServerCodec是netty提供的助手类, 可以理解为拦截器
        // 当请求到服务端, 我们需要做解码, 响应到客户端做编码
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());

        // 添加自定义助手类,返回"hello netty"
        pipeline.addLast("customHandler", null);
    }
}
