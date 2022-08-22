package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import availability.junit.TestApplication;
import availability.junit.dao.CustomerRepository;
import availability.junit.entity.Customer;

@Transactional
@Rollback
@SpringBootTest(classes = TestApplication.class)
public class CustomerTesting {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void findCustomerById() {
		Customer customer = new Customer();
		customer.setFirstName("test1");
		customerRepository.save(customer);

		Customer customer2 = customerRepository.findById(customer.getId()).get();
		Assertions.assertNotNull(customer2);
		Assertions.assertEquals("test1", customer2.getFirstName());
	}

	@Test
	void testCustomerRepository() {
		Assertions.assertNotNull(customerRepository);
	}

	@Test
	void testDeleteUser() {
		Customer customer = new Customer();
		customerRepository.save(customer);

		int testId = customer.getId();

		customerRepository.deleteById(testId);
		Assertions.assertFalse(customerRepository.findById(testId).isPresent());
	}

}
