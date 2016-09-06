/**
 * Created on  13-09-12 19:02
 */
package com.alicp.jetcache.local;

import com.alicp.jetcache.support.CacheConfig;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author <a href="mailto:yeli.hl@taobao.com">huangli</a>
 */
public class LinkedHashMapCache extends AbstractLocalCache {

    public LinkedHashMapCache(){
    }

    public LinkedHashMapCache(boolean useSoftRef){
        super(useSoftRef);
    }

    @Override
    protected AreaCache createAreaCache(int localLimit){
        return new LRUMap(localLimit);
    }

    private static final class LRUMap extends LinkedHashMap implements AreaCache {

        private final int max;

        public LRUMap(int max) {
            super((int) (max * 1.4f), 0.75f, true);
            this.max = max;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > max;
        }

        public synchronized Object getValue(String key) {
            return get(key);
        }

        public synchronized Object putValue(String key, Object value) {
            return put(key, value);
        }

        public synchronized Object removeValue(String key) {
            return remove(key);
        }
    }


}

