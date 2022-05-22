package com.redission.configuration;

//import org.redisson.Redisson;
//import org.redisson.api.LocalCachedMapOptions;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.redisson.spring.cache.CacheConfig;
//import org.redisson.spring.cache.RedissonSpringCacheManager;
//import org.springframework.cache.CacheManager;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiazhiyuan
 * @date 2022/5/21 10:31 上午
 */

@Configuration
public class RedissionConfiguration {



//    @Bean
//    RedissonClient getRedissonClient() {
//        Config config = new Config();
//        config.useSingleServer()
//                .setAddress("redis://localhost:6379");
//
//        //2.
//        //create Redisson API
//        //Sync and Async API
//        RedissonClient redisson = Redisson.create(config);
//        return  redisson;
//    }

//    @Bean
//    CacheManager cacheManager(RedissonClient redissonClient) {
//        Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
//        LocalCachedMapOptions options = LocalCachedMapOptions.defaults()
//                .evictionPolicy(LocalCachedMapOptions.EvictionPolicy.LFU)
//                .cacheSize(1000);
//        // 创建一个名称为"testMap"的缓存，过期时间ttl为24分钟，同时最长空闲时maxIdleTime为12分钟。
//        config.put("testMap", new CacheConfig(24*60*1000, 12*60*1000));
//        return new RedissonSpringCacheManager(redissonClient, config);
//    }
}



    
