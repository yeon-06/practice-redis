package com.example.redis.example1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisTemplateTest {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	private static final String KEY = "key";

	@BeforeEach
	void save() {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.set(KEY, "value");
	}

	@Test
	void test() {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		String result = operations.get(KEY);

		assertThat(result).isEqualTo("value");
	}
}
