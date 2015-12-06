package com.incra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.incra.config.ArchaiusAppConfig;
import com.incra.config.RedisConfig;
import com.incra.model.JobDescription;
import com.incra.service.RedisClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Jeff Risberg
 * @since 11/29/15
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ArchaiusAppConfig appConfig = new ArchaiusAppConfig();
        RedisConfig redisConfig = new RedisConfig(appConfig, "redis");
        RedisClient redis = new RedisClient(redisConfig);
        
        redis.set("foo", "bar");
        String fooValue = redis.get("foo");
        System.out.println(fooValue);

        redis.zadd("sose", 0, "car");
        redis.zadd("sose", 0, "bike");
        Set<String> sose = redis.zrange("sose", 0, -1);

        List<JobDescription> jobs = new ArrayList<JobDescription>();

        jobs.add(new JobDescription(1, "alpha", "s3://xyz14", "java -cp", 10));

        jobs.add(new JobDescription(2, "beta", "s3://def22", "java -cp", 5));

        jobs.add(new JobDescription(3, "gamma", "s3://dwer77", "java -cp", 7));

        // Populate jobs
        ObjectMapper objectMapper = new ObjectMapper();

        redis.del("jobs");

        for (JobDescription job : jobs) {
            String jobJson = objectMapper.writeValueAsString(job);

            redis.set("job:" + job.getId(), jobJson);
            redis.lpush("jobs", jobJson);
        }

        // Dump all keys
        Set<String> keyList = redis.keys("*");
        Iterator iter1 = keyList.iterator();
        while (iter1.hasNext()) {
            Object key = iter1.next();
            System.out.println("Stored key " + key);
        }

        // Dump all jobs
        Long length = redis.llen("jobs");
        System.out.println("There are " + length + " jobs");

        List<String> values = redis.lrange("jobs", 0, 150);
        Iterator iter2 = values.iterator();
        while (iter2.hasNext()) {
            String value = (String) iter2.next();
            System.out.println("Stored value " + value);

            JobDescription job = objectMapper.readValue(value, JobDescription.class);
            System.out.println(job);
        }
    }
}
