package com.availability.dao;

import java.util.List;

import com.availability.entity.Customer;
import com.availability.entity.Event;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Event> updateCustomerEventList(int c, int e);

	Customer validateCustomer(Customer theCustomer);

	public Customer getCustomerByEmail(String email);

	public List<Event> getCustomerEvents(int currentUser);

	public List<Event> getNonCustomerEvents(int currentUser);

	public void removeCustomerEventList(int c, int e);
}
