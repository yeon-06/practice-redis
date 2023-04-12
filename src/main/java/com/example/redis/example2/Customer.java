package com.example.redis.example2;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {

	private Long id;
	private String name;
	private String email;
	private LocalDate birthday;

	public Customer(String name, String email, LocalDate birthday) {
		this.name = name;
		this.email = email;
		this.birthday = birthday;
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

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
}
