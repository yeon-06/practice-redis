package com.example.redis.example1;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Member")
public class Member {

	private Long id;
	private String email;
	private String name;
	private Grade grade;

	public enum Grade {
		BASIC, VIP
	}

	public Member(String email, String name, Grade grade) {
		this.email = email;
		this.name = name;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public Grade getGrade() {
		return grade;
	}
}
