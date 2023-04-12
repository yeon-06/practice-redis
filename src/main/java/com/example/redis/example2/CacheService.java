package com.example.redis.example2;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	private final ItemRepository itemRepository;
	private final CustomerRepository customerRepository;

	public CacheService(ItemRepository itemRepository, CustomerRepository customerRepository) {
		this.itemRepository = itemRepository;
		this.customerRepository = customerRepository;
	}

	@Cacheable(value = "itemCache")
	public Item findItemById(Long id) {
		return itemRepository.getById(id);
	}

	@Cacheable(value = "customerCache")
	public Customer findCustomerById(Long id) {
		return customerRepository.getById(id);
	}
}
