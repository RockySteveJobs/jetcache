/**
 * Created on  13-09-10 10:33
 */
package com.taobao.geek.jetcache;

/**
 * @author <a href="mailto:yeli.hl@taobao.com">huangli</a>
 */
public class CacheConfig {

    public static final String DEFAULT_AREA = "";
    public static final boolean DEFAULT_ENABLED = true;
    public static final int DEFAULT_EXPIRE = 600;
    public static final CacheType DEFAULT_CACHE_TYPE = CacheType.REMOTE;
    public static final int DEFAULT_LOCAL_LIMIT = 100;
    public static final int DEFAULT_VERSION = 1;
    public static final boolean DEFAULT_CACHE_NULL_VALUE = false;

    private String area = DEFAULT_AREA;
    private boolean enabled = DEFAULT_ENABLED;
    private int expire = DEFAULT_EXPIRE;
    private CacheType cacheType = DEFAULT_CACHE_TYPE;
    private int localLimit = DEFAULT_LOCAL_LIMIT;
    private int version = DEFAULT_VERSION;
    private boolean cacheNullValue = DEFAULT_CACHE_NULL_VALUE;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CacheConfig)) {
            return false;
        }
        CacheConfig cc = (CacheConfig) obj;
        return equals(area, cc.area) &&
                enabled == cc.enabled && expire == cc.expire
                && equals(cacheType, cc.cacheType) && localLimit == cc.localLimit
                && version == cc.version && cacheNullValue == cc.cacheNullValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (area != null) {
            hash += area.hashCode();
        }
        hash = hash << 8 + expire;
        if (cacheType != null) {
            hash = hash << 2 + cacheType.hashCode();
        }
        hash = hash << 8 + localLimit;
        hash =  hash << 4 + version;

        if (enabled) {
            hash += 11;
        }
        if(cacheNullValue){
            hash += 101;
        }
        return hash;
    }

    private boolean equals(Object o1, Object o2) {
        if (o1 != null) {
            return o1.equals(o2);
        } else {
            return o2 == null;
        }
    }

    public String getArea() {
        return area;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getExpire() {
        return expire;
    }

    public CacheType getCacheType() {
        return cacheType;
    }

    public int getLocalLimit() {
        return localLimit;
    }

    public int getVersion() {
        return version;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public void setCacheType(CacheType cacheType) {
        this.cacheType = cacheType;
    }

    public void setLocalLimit(int localLimit) {
        this.localLimit = localLimit;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isCacheNullValue() {
        return cacheNullValue;
    }

    public void setCacheNullValue(boolean cacheNullValue) {
        this.cacheNullValue = cacheNullValue;
    }
}
