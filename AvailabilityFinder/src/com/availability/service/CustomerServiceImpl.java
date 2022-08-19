package com.availability.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.availability.dao.CustomerDAO;
import com.availability.dao.EventsDAO;
import com.availability.entity.Customer;
import com.availability.entity.Event;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private EventsDAO eventsDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public List<Event> getEvents() {
		return eventsDAO.getEvents();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Event> updateCustomerEventList(int c, int e) {
		// step 3 of many to many call DAO
		return customerDAO.updateCustomerEventList(c, e);
	}

	@Override
	@Transactional
	public Event getEvent(int theId) {

		return eventsDAO.getEvent(theId);
	}

	@Override
	@Transactional
	public Object validateCustomer(Customer theCustomer) {

		return customerDAO.validateCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomerByEmail(String email) {

		return customerDAO.getCustomerByEmail(email);
	}

	@Override
	@Transactional
	public List<Event> getCustomerEvents(int currentUser) {

		return customerDAO.getCustomerEvents(currentUser);
	}

	@Override
	@Transactional
	public List<Event> getNonUserEvents(int currentUser) {

		return customerDAO.getNonCustomerEvents(currentUser);
	}

	@Override
	@Transactional
	public void removeCustomerEventList(int c, int e) {

		customerDAO.removeCustomerEventList(c, e);

	}

}
