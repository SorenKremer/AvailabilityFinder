package com.luv2code.springboot.thymeleafdemo;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LearningTest {

	@Test
	public void encrypt_password() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String encodedPassword = passwordEncoder.encode("!VerySecure");

		System.out.println(encodedPassword);
	}
}
