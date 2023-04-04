package com.example.redis.example1;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.redis.example1.Member.Grade;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	void select() {
		Member member = new Member("yeonlog06@gmail.com", "연로그", Grade.VIP);
		Long savedId = memberRepository.save(member)
			.getId();

		Optional<Member> result = memberRepository.findById(savedId);

		assertThat(result).isPresent();
		Member foundMember = result.get();
		assertThat(foundMember.getId()).isEqualTo(savedId);
		assertThat(foundMember.getEmail()).isEqualTo(member.getEmail());
		assertThat(foundMember.getName()).isEqualTo(member.getName());
		assertThat(foundMember.getGrade()).isEqualTo(member.getGrade());
	}
}
