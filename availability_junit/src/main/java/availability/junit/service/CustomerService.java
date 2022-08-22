package availability.junit.service;

import java.util.List;

import availability.junit.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	// public List<Event> getEvents();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	// public Event getEvent(int theId);

	public void deleteCustomer(int theId);

	// public List<Event> updateCustomerEventList(int c, int e);

	// public Object validateCustomer(Customer theCustomer);

}
