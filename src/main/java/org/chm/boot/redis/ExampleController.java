package org.chm.boot.redis;

import org.chm.boot.redis.entity.ResponseModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

/**
 * Created by charming on 2017/7/5.
 */
@RestController
public class ExampleController {


    @Autowired
    private IRedisService redisService;


    @RequestMapping("/redis/set")
    public ResponseModal redisSet(@RequestParam("value")String value){
        boolean isOk = redisService.set("name", value);
        return new ResponseModal(isOk ? 200 : 500, isOk, isOk ? "success" : "error" , null);
    }

    @RequestMapping("/redis/get")
    public ResponseModal redisGet(){
        String name = redisService.get("name");
        return new ResponseModal(200, true,"success",name);
    }

    @RequestMapping("redis/expire/{time}")
    public String expire(@PathVariable("time") Long time)
    {
        boolean result = redisService.expire("name", time);
        return  result?"ok":"false";
    }

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("redis/poolset")
    public String setValue(@RequestParam("key")String key, @RequestParam("value") String value)
    {
        return set(key, value);
    }

    @RequestMapping("redis/poolget/{key}")
    public String getValue(@PathVariable("key")String key)
    {
        return get(key);
    }

    public String set(String key, String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key, value);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    public String get(String key)  {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }
}
