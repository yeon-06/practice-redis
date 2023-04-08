package com.example.redis.example2.configuration;

import java.time.Duration;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
public class CacheConfiguration {

	@Bean
	public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
		return builder -> builder
			.withCacheConfiguration("itemCache", itemCacheConfiguration())
			.withCacheConfiguration("customerCache", customerCacheConfiguration());
	}

	private RedisCacheConfiguration itemCacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
			.entryTtl(Duration.ofMinutes(1))
			.disableCachingNullValues()
			.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

	private RedisCacheConfiguration customerCacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
			.entryTtl(Duration.ofMinutes(5));
	}
}
