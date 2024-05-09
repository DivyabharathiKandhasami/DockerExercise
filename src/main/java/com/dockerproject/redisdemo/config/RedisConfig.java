package com.dockerproject.redisdemo.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
@Configuration
@EnableCaching
public class RedisConfig {  
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory(){
		
	
	   RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
	   redisStandaloneConfiguration.setHostName("192.168.1.36");    
	   redisStandaloneConfiguration.setPort(6379);
	    //redisStandaloneConfiguration.setPassword("password");                   //redisStandaloneConfiguration
	    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory( );
		return jedisConnectionFactory;
		}


		@Bean
		public RedisTemplate <String,Object> redisTemplate(){


		RedisTemplate <String,Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer( new JdkSerializationRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
		}
}

	
	
	
	
	
	


