package org.netty.example.version4.usePOJO;

import java.util.Date;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 15:42 2018/6/29
 * @Modified By:
 */
public class UnixTime {

    private final long value;

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        return new Date((value() - 2208988800L) * 1000L).toString();
    }
}
