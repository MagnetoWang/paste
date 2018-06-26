package cacheUtils;

import org.ehcache.*;
import org.ehcache.config.Builder;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.builders.UserManagedCacheBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.core.spi.service.LocalPersistenceService;
import org.ehcache.impl.config.persistence.DefaultPersistenceConfiguration;
import org.ehcache.impl.config.persistence.UserManagedPersistenceContext;
import org.ehcache.impl.persistence.DefaultLocalPersistenceService;
import org.ehcache.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Date;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;


public class ConfigCachae {
    private  static Logger logger= LoggerFactory.getLogger(ConfigCachae.class);
    public static void main(String[] args) {


        config();


    }


//

    /**
     * 初始化缓存，并设置缓存实体的存活时间。相当于一个模板
     *
     * 参考网站
     * http://www.ehcache.org/documentation/3.5/expiry.html
     * http://www.ehcache.org/documentation/3.5/usermanaged.html
     * http://www.ehcache.org/documentation/3.5/
     */
    public static void config(){
        final URL myUrl = ConfigCachae.class.getResource("ehcache.xml");
        System.out.println(myUrl);
        Configuration xmlConfig = new XmlConfiguration(myUrl);
        CacheManager myCacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        myCacheManager.init();
//        Cache<String ,String> mycache=myCacheManager.createCache("mycache",
//                CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class, ResourcePoolsBuilder.heap(10)));

        Cache<String ,String> mycache=myCacheManager.getCache("mycache",String.class, String.class);
        mycache.put("test","哈哈");
        System.out.println(new Date());
        while (true){
            if(mycache.containsKey("test")==false){
                System.out.println(new Date());
                break;
            }

        }
        myCacheManager.close();
    }


}
