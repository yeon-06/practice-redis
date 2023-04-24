package com.example.redis.example2;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheServiceTest {

	@Autowired
	private CacheService cacheService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	void cachable() {
		// init data
		customerRepository.save(new Customer("연로그", "yeonlog06@gmail.com", LocalDate.of(1997, 6, 13)));
		itemRepository.save(new Item("상품 A", 1_000L));

		// 아래 코드 실행 후 Redis에서 조회하면 해당 값들이 저장되어 있음
		cacheService.findCustomerById(1L);
		cacheService.findItemById(1L);

		// configuration에 지정한 시간이 지나면 redis에서 삭제된 것을 확인할 수 있음
	}

	@Test
	void cacheEvict() {
		// init data
		itemRepository.save(new Item("상품 A", 1_000L));
		Long id = 1L;

		// 아래 코드 실행 후 Redis에서 조회하면 해당 값이 저장되어 있음
		cacheService.findItemById(id);

		// 아래 코드 실행 후 Redis에서 조회하면 해당 값이 삭제되어 있음
		cacheService.deleteItemById(id);
	}
}
