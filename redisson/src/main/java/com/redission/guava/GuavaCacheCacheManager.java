package com.redission.guava;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * @author jiazhiyuan
 * @date 2022/5/22 12:26 下午
 */
public class GuavaCacheCacheManager extends AbstractCacheManager {


    @Override
    protected Collection<? extends Cache> loadCaches() {
        return null;
    }
}



    
