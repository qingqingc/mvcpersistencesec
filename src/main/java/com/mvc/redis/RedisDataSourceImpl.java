package com.mvc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mvc.utilities.U;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Component
public class RedisDataSourceImpl implements RedisDataSource {
	
	@Autowired
    private ShardedJedisPool    shardedJedisPool;
	@Override
	public ShardedJedis getRedisClient() {
		 try {
	            ShardedJedis shardJedis = shardedJedisPool.getResource();
	            return shardJedis;
	        } catch (Exception e) {e.printStackTrace();
	        }
	        return null;
	}

	@Override
	public void returnResource(ShardedJedis shardedJedis) {
		shardedJedisPool.returnResource(shardedJedis);
	}

	@Override
	public void returnResource(ShardedJedis shardedJedis, boolean broken) {
		if (broken) {
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } else {
            shardedJedisPool.returnResource(shardedJedis);
        }
	}

}
