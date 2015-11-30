package com.incra;

import redis.clients.jedis.Jedis;

/**
 * Created by jeff on 11/29/15.
 */
public class Main {


    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("52.27.1.250", 6379);
        //jedis.auth("password");
        System.out.println("Connected to Redis");

        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }

}
