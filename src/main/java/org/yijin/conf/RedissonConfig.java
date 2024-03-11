package org.yijin.conf;

import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author YiJin840
 * @program inspiration
 * @description redisson
 * @since 2024-03-05 20:07
 **/
@RequiredArgsConstructor
public class RedissonConfig {

    private final RedisProperties redisProperties;
    @Bean
    public RedissonClient redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress(redisProperties.getUrl());
        config.useSingleServer().setPassword(redisProperties.getPassword());
        config.useSingleServer().setTimeout(redisProperties.getTimeout().getNano());
        //字符序列
        config.setCodec(StringCodec.INSTANCE);
        return Redisson.create(config);
    }


}
