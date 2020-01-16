package com.renjack.webdemo.config.redis;

import java.util.concurrent.TimeUnit;

public interface RedisService {

    /**
     * set存数据
     * @param key
     * @param value
     * @return
     */
    void set(String key, String value, long expire, TimeUnit unit);

    /**
     * get获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置有效天数
     * @param key
     * @param expire 单位：秒
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 移除数据
     * @param key
     * @return
     */
    boolean remove(String key);

}
