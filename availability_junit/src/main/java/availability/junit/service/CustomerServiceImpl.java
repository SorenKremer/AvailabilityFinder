package availability.junit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import availability.junit.dao.CustomerRepository;
import availability.junit.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerRepository.findAllByOrderByLastNameAsc();
	}/*
		 * @Override
		 * 
		 * @Transactional public List<Event> getEvents() { return eventsDAO.getEvents();
		 * }
		 */

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Optional<Customer> result = customerRepository.findById(theId);

		Customer theCustomer = null;

		if (result.isPresent()) {
			theCustomer = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find customer id - " + theId);
		}

		return theCustomer;

	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerRepository.deleteById(theId);
	}

//	@Override
//	@Transactional
//	public List<Event> updateCustomerEventList(int c, int e) {
//		// step 3 of many to many call DAO
//		return customerDAO.updateCustomerEventList(c, e);
//	}
//
//	@Override
//	@Transactional
//	public Event getEvent(int theId) {
//
//		return eventsDAO.getEvent(theId);
//	}

//	@Override
//	@Transactional
//	public Object validateCustomer(Customer theCustomer) {
//
//		return customerDAO.validateCustomer(theCustomer);
//	}

}
