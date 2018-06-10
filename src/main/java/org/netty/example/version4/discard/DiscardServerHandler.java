package org.netty.example.version4.discard;

import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;


/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 10:15 2018/5/31
 * @Modified By:
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        System.out.println("accepting");
        ((ByteBuf) msg).release(); // (3)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // 当出现异常时关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    public void channelRead1(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) {
                System.out.println((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    public void channelRead2(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            System.out.println(in.toString(CharsetUtil.US_ASCII));
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    public void channelRead3(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            System.out.println(in.release());
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
