package com.incra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incra.model.JobDescription;
import redis.clients.jedis.Jedis;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.*;

/**
 * Created by jeff on 11/29/15.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("52.27.1.250", 6379);
        //jedis.auth("password");
        System.out.println("Connected to Redis");

        jedis.set("foo", "bar");
        String fooValue = jedis.get("foo");
        System.out.println(fooValue);

        jedis.zadd("sose", 0, "car");
        jedis.zadd("sose", 0, "bike");
        Set<String> sose = jedis.zrange("sose", 0, -1);

        List<JobDescription> jobs = new ArrayList<JobDescription>();
        {
            JobDescription job;

            job = new JobDescription(1, "alpha", "s3://xyz14", "java -cp", 10);
            jobs.add(job);

            job = new JobDescription(2, "beta", "s3://def22", "java -cp", 5);
            jobs.add(job);

            job = new JobDescription(3, "gamma", "s3://dwer77", "java -cp", 7);
            jobs.add(job);
        }

        // Populate jobs
        ObjectMapper objectMapper = new ObjectMapper();

        jedis.del("jobs");

        for (JobDescription job : jobs) {
            String jobJson = objectMapper.writeValueAsString(job);

            jedis.set("job:" + job.getId(), jobJson);
            jedis.lpush("jobs", jobJson);
        }

        // Dump all keys
        Set<String> keyList = jedis.keys("*");
        Iterator iter1 = keyList.iterator();
        while (iter1.hasNext()) {
            Object key = iter1.next();
            System.out.println("Stored key " + key);
        }

        // Dump all jobs
        Long length = jedis.llen("jobs");
        System.out.println("There are " + length + " jobs");

        List<String> values = jedis.lrange("jobs", 0, 150);
        Iterator iter2 = values.iterator();
        while (iter2.hasNext()) {
            String value = (String) iter2.next();
            System.out.println("Stored value " + value);

            JobDescription job = objectMapper.readValue(value, JobDescription.class);
            System.out.println(job);
        }
    }

}
