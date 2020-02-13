package com.shenjinxiang.jkits.kit;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisFactory {

    public static JedisPool jedisPool = null;

    private JedisFactory() {
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(0);
        config.setMaxIdle(Config.REDIS_MAXIDLE);
        config.setMaxTotal(Config.REDIS_MAXTOTAL);
        config.setMinEvictableIdleTimeMillis(1200000L);
        config.setSoftMinEvictableIdleTimeMillis(1200000L);
        config.setMaxWaitMillis(60000L);
        config.setTestOnBorrow(true);
        jedisPool = new JedisPool(config, Config.REDIS_HOST, Config.REDIS_PORT, 60000, Config.REDIS_AUTH);
    }
}
