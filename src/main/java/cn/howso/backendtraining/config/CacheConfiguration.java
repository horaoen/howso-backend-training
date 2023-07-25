package cn.howso.backendtraining.config;

import cn.hutool.db.nosql.redis.RedisDS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {
    @Bean
    public RedisDS redisDS() {
        return RedisDS.create();
    }
}
