package com.example.redis.example2;

import java.io.Serializable;

public class Item implements Serializable {

	private Long id;
	private String name;
	private Long price;

	public Item(String name, Long price) {
		this.name = name;
		this.price = price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getPrice() {
		return price;
	}
}
