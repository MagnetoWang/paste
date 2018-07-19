package cacheUtils;

import org.apache.commons.collections.map.LinkedMap;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.time.Duration;


import org.ehcache.expiry.ExpiryPolicy;
import org.ehcache.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

import java.util.function.Supplier;


/***
 * ehcache3 采取一个生命周期的概念来操作动态运行程序的缓存时间
 */
public class UpdateExpire {
    private  static Logger logger= LoggerFactory.getLogger(ConfigCachae.class);

    public static void main(String[] args) throws InterruptedException {
        fragment1();
    }

    public static void fragment1() throws InterruptedException {
        final URL myUrl = ConfigCachae.class.getResource("/cache/ehcache.xml");
        System.out.println(myUrl);
        Configuration xmlConfig = new XmlConfiguration(myUrl);
        CacheManager myCacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        myCacheManager.init();
        CacheManager cacheManager = myCacheManager;
        CacheConfigurationBuilder<Long, String> configuration =
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder
                        .heap(100))
                        .withExpiry(new ExpiryPolicy<Long, String>() {
                            @Override
                            public Duration getExpiryForCreation(Long key, String value) {
                                return getTimeToLiveDuration(key, value);
                            }

                            @Override
                            public Duration getExpiryForAccess(Long key, Supplier<? extends String> value) {
                                return null;  // Keeping the existing expiry
                            }

                            @Override
                            public Duration getExpiryForUpdate(Long key, Supplier<? extends String> oldValue, String newValue) {
                                return null;  // Keeping the existing expiry
                            }
                        });
        cacheManager.createCache("cache", configuration);

        Cache<Long, String> cache = cacheManager.getCache("cache", Long.class, String.class);
        cache.put(10L, "Hello");
//        Map<String,String> content=(LinkedMap)value;


        Long expireTime =new Long(3L);
        cache.put(3L,expireTime.toString());

//        Duration.ofSeconds(Long.parseLong(content.get("timeToLive")));

        System.out.println(cache.get(10L));

//        sleep(2100);

// Now the returned value should be null, as mapping is expired.
        System.out.println(cache.get(10L));
    }
    /**
     * Returns the expiry duration for the given key/value pair, based on some complex logic.
     * @param key Cache Key
     * @param value Cache Value
     * @return return expiry duration
     */
    private static Duration getTimeToLiveDuration(Long key, String value) {
        // Returns TTL of 10 seconds for keys less than 1000
        if (key < 1000) {
            return Duration.ofSeconds(2);
        }

        // Otherwise return 5 seconds TTL
        return Duration.ofSeconds(5);
    }
}
