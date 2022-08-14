package com.atguigu.utils;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author jian
 * @create 2022-08-02 23:32
 */
public class MyCacheUtil {

    public static boolean if_key(String key){
        Jedis jedis = null;
        //第三方数据库调用
        try {
            jedis = JedisPoolUtils.getJedis();
        }catch (Exception e){
            //记日志
        }
        Boolean exists = jedis.exists(key);
        return exists;
    }

    public static <T> void setKey(String key , List<T> list){
        Jedis jedis = null;
        //第三方数据库调用
        try {
            jedis = JedisPoolUtils.getJedis();
        }catch (Exception e){
            //记日志
        }

        jedis.del(key);

        //同步redis
        for (int i = 0; i < list.size(); i++) {
            jedis.zadd(key,i,MyJsonUtil.object_to_json(list.get(i)));
        }
    }

    public static String interKeys(String... keys){
        Jedis jedis = null;
        //第三方数据库调用
        try {
            jedis = JedisPoolUtils.getJedis();
        } catch (Exception e) {
            return null;
        }

        //生成动态的key,体现出查询条件
        String k0 = "combine";
        for (int i = 0; i < keys.length; i++) {
            k0 = k0 + "_"+keys[i];
        }

        if (!jedis.exists(k0)){
            jedis.zinterstore(k0, keys);
        }
        return k0;
    }

    public static <T> List<T> getList(String key, Class<T> t) {
        List<T> list = new ArrayList<>();

        Jedis jedis = null;
        //第三方数据库调用
        try {
           jedis = JedisPoolUtils.getJedis();
        }catch (Exception e){
            return null;
        }

        Set<String> zrange = jedis.zrange(key, 0, -1);
        Iterator<String> iterator = zrange.iterator();
        while (iterator.hasNext()) {
            String skuStr = iterator.next();

            T sku = MyJsonUtil.json_to_object(skuStr, t);

            list.add(sku);
        }
        return list;
    }

}
