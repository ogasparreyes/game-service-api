package com.example.game_service_api.config;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;



public class CacheConfiguration {

    /**
     * útil para liberar recursos, como cerrar conexiones a bases de datos,
     * liberar memoria, o en este caso, cerrar un cliente de Redis.
     * */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379"); // Cambia la dirección y el puerto si es necesario
        return Redisson.create(config);
    }

    @Bean
    public CacheManager getManager(RedissonClient redissonClient){
       // return new ConcurrentMapCacheManager("cache_games"); spring cache
        Map<String, CacheConfiguration> config = new HashMap<>();
        config.put("cache_games",new CacheConfiguration());
        return new RedissonSpringCacheManager(redissonClient);
    }
}
