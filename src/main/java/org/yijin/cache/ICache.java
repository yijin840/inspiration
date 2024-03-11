package org.yijin.cache;

/**
 * @author YiJin840
 * @program inspiration
 * @description i cache
 * @since 2024-03-05 19:59
 **/
public interface ICache<T> {

    /**
     * 获取当前缓存对象
     * @param key 缓存对象的key
     * @return 当前缓存对象
     */
    T get(String key);

    /**
     * 设置获取当前缓存对象
     */
    void set(String key, T obj);

    /**
     * 移除缓存对象
     * @param key 缓存对象的key
     */
    void remove(String key);
}
