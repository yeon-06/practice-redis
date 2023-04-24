package com.example.redis.example2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

	private Long id = 1L;
	private final Map<Long, Item> items = new HashMap<>();

	public void save(Item item) {
		item.setId(id);
		items.put(id, item);
		id++;
	}

	public Item getById(Long id) {
		return items.get(id);
	}

	public void deleteById(Long id) {
		items.remove(id);
	}
}
