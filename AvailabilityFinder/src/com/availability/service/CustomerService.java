package com.availability.service;

import java.util.List;

import com.availability.entity.Customer;
import com.availability.entity.Event;

public interface CustomerService {

	public List<Customer> getCustomers();

	public List<Event> getEvents();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public Event getEvent(int theId);

	public void deleteCustomer(int theId);

	public List<Event> updateCustomerEventList(int c, int e);

	public Object validateCustomer(Customer theCustomer);

	public Customer getCustomerByEmail(String email);

	public List<Event> getCustomerEvents(int currentUser);

	public List<Event> getNonUserEvents(int currentUser);

	public void removeCustomerEventList(int currentUser, int eId);

}
