package com.booo.spring.controller;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * 创建自定义助手类
 */
public class CustomHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress());

        // 创建缓冲区,交互数据
        ByteBuf content = Unpooled.copiedBuffer("Hello, Netty", CharsetUtil.UTF_8);

        // 构建http response
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,
                    content);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
    }
}
