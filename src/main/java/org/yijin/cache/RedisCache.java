package org.yijin.cache;

import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author YiJin840
 * @program inspiration
 * @description redis cache
 * @since 2024-03-05 20:04
 **/
@Component
public class RedisCache<T> implements ICache<T> {

    @Autowired
    private RedissonClient redisson;

    @Override
    public T get(String key) {
        RBucket<T> bucket = redisson.getBucket(key);
        return bucket.get();
    }

    @Override
    public void set(String key, T obj) {
        redisson.getBucket(key).set(obj);
    }

    public void setAndExpire(String key, T obj, Long time) {
        RBucket<T> bucket = redisson.getBucket(key);
        bucket.set(obj);
        bucket.expire(time, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        redisson.getBucket(key).delete();
    }

    public void lock(String key, Long time) {
        RLock fairLock = redisson.getFairLock(key);
        if(Objects.isNull(time)) {
            fairLock.lock();
        } else {
            fairLock.lock(time, TimeUnit.SECONDS);
        }
    }

    public void unlock(String key) {
        RLock fairLock = redisson.getFairLock(key);
        if(fairLock.isLocked()) {
            fairLock.unlock();
        }
     }

}
