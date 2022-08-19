package com.availability.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.availability.entity.Customer;
import com.availability.entity.Event;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// saveOrUpdate the customer ... finally LOL
		// hibernate knows what to do because there is already a primary key attached to
		// theCustomer
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// declare the query
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

		// add the details of what to delete
		theQuery.setParameter("customerId", theId);
		// run the query
		theQuery.executeUpdate();

	}

	// many to many, make relationship happen
	@Override
	public List<Event> updateCustomerEventList(int c, int e) {

		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using the primary key
			Customer theCustomer = currentSession.get(Customer.class, c);

			List<Event> theEvents = theCustomer.getCustomerEvents();

			Event theEvent = currentSession.get(Event.class, e);

			theEvents.add(theEvent);

			// save new event list to customer
			theCustomer.setCustomerEvents(theEvents);

			currentSession.update(theCustomer);

			return theEvents;
		} catch (NullPointerException error) {
			return null;
		}

	}

	@Override
	public Customer validateCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Query<Customer> theQuery = currentSession.createQuery("from Customer where email=:email", Customer.class);
		theQuery.setParameter("email", theCustomer.getEmail());
		Customer validation = theQuery.getSingleResult();

		if (validation.getPassword().equals(theCustomer.getPassword())) {
			return validation;
		} else {
			return null;
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Query<Customer> theQuery = currentSession.createQuery("from Customer where email=:email", Customer.class);

		theQuery.setParameter("email", email);

		Customer validation = theQuery.getSingleResult();

		if (validation != null) {
			return validation;
		} else {
			return null;
		}
	}

	@Override
	public List<Event> getCustomerEvents(int currentUser) {
		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using the primary key
			Customer theCustomer = currentSession.get(Customer.class, currentUser);

			List<Event> theEvents = theCustomer.getCustomerEvents();

			List<Event> testEvents = new ArrayList<Event>(theEvents);
			return testEvents;

		} catch (NullPointerException error) {
			return null;
		}

	}

	@Override
	public List<Event> getNonCustomerEvents(int currentUser) {
		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create a query
			Query<Event> theQuery = currentSession.createQuery("from Event", Event.class);

			// execute query and get result list
			List<Event> theEvents = theQuery.getResultList();

			// now retrieve/read from database using the primary key
			Customer theCustomer = currentSession.get(Customer.class, currentUser);

			List<Event> userEvents = theCustomer.getCustomerEvents();

			List<Event> nonUserEvents = new ArrayList<Event>();

			for (Event theEvent : theEvents) {
				if (!userEvents.contains(theEvent)) {
					nonUserEvents.add(theEvent);
				}
			}
			return nonUserEvents;
		} catch (NullPointerException error) {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// create a query
			Query<Event> theQuery = currentSession.createQuery("from Event", Event.class);

			// execute query and get result list
			List<Event> theEvents = theQuery.getResultList();

			return theEvents;
		}
	}

	@Override
	public void removeCustomerEventList(int c, int e) {
		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using the primary key
			Customer theCustomer = currentSession.get(Customer.class, c);

			List<Event> theEvents = theCustomer.getCustomerEvents();

			Event theEvent = currentSession.get(Event.class, e);

			theEvents.remove(theEvent);

			// save new event list to customer
			theCustomer.setCustomerEvents(theEvents);

			currentSession.update(theCustomer);

		} catch (NullPointerException error) {

		}

	}

}
