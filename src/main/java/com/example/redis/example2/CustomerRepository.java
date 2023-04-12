package com.example.redis.example2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

	private Long id = 1L;
	private final Map<Long, Customer> customers = new HashMap<>();

	public void save(Customer customer) {
		customer.setId(id);
		customers.put(id, customer);
		id++;
	}

	public Customer getById(Long id) {
		return customers.get(id);
	}
}
