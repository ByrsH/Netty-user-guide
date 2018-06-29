package org.netty.example.version4.usePOJO;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 16:11 2018/6/29
 * @Modified By:
 */
public class TimeEncoder2 extends MessageToByteEncoder<UnixTime> {
    @Override
    protected void encode(ChannelHandlerContext ctx, UnixTime msg, ByteBuf out) throws Exception {
        out.writeInt((int) msg.value());
    }
}
