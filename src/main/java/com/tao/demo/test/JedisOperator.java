package com.tao.demo.test;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;
import java.util.Set;

public class JedisOperator {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("121.4.35.196", 6379);
        Pipeline pipeline = jedis.pipelined();
        pipeline.set("hello", "world");
        pipeline.incr("count");
        List<Object> list = pipeline.syncAndReturnAll();
        for (Object object:list) {
            System.out.println(object);
        }
    }
}
