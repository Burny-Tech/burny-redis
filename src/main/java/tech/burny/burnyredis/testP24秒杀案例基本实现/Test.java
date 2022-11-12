package tech.burny.burnyredis.testP24秒杀案例基本实现;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ClusterSlotHashUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Note TODO
 * @Author cyx
 * @Date 2022/9/15 22:28
 */


@Service
public class Test {


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void doSecKill() {
        String uuid = UUID.randomUUID().toString();
        Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent("key", uuid, 100, TimeUnit.SECONDS);
        if (aBoolean) {
            //手动释放锁
            if (uuid.equals((String) stringRedisTemplate.opsForValue().get("key"))) {
                stringRedisTemplate.delete("key");
            }
        }
    }


    public void doSecKill2() throws InterruptedException {
        Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent("key", "value", 100, TimeUnit.SECONDS);
        if (aBoolean) {
            //手动释放锁
            Thread.sleep(20*1000);
            stringRedisTemplate.delete("key");
        }
    }

    public void testww(){
        //  org.springframework.data.redis.connection
        ClusterSlotHashUtil.calculateSlot("A");
        ClusterSlotHashUtil.calculateSlot("B");
        ClusterSlotHashUtil.calculateSlot("C");
    }


}
