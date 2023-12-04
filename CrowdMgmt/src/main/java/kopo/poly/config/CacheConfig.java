package kopo.poly.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactoryBean() {
        return new EhCacheManagerFactoryBean();
    }


    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
        CacheConfiguration conf = new CacheConfiguration()
                .eternal(false) // cache 구성 false == 비영구
                .timeToIdleSeconds(0) // 유휴시간 설정
                .timeToLiveSeconds(3595) // cache 존재 시간 이 시간이 지나면 캐시 삭제 //TODO 59분
                .maxEntriesLocalHeap(0) // Heap 캐시 메모리 사이즈 설정
                .memoryStoreEvictionPolicy("LRU") // 캐시가 가득 찼을때 알고리즘 설정
                .name("seoulCityData"); // 캐시 이름

        Cache cache = new net.sf.ehcache.Cache(conf);

        Objects.requireNonNull(cacheManagerFactoryBean().getObject()).addCache(cache);

        return new EhCacheCacheManager(Objects.requireNonNull(cacheManagerFactoryBean().getObject()));
    }
}