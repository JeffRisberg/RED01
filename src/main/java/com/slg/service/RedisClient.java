package com.slg.service;

import com.slg.config.RedisConfig;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * @author Jeff Risberg
 * @since 12/05/15
 */
public class RedisClient extends Jedis {

    protected RedisConfig redisConfig;

    public RedisClient(RedisConfig redisConfig) {
        super(redisConfig.getServer(), redisConfig.getPort());
        this.redisConfig = redisConfig;

        if (StringUtils.isNotBlank(redisConfig.getPassword())) {
            this.auth(redisConfig.getPassword());
        }
    }
}
