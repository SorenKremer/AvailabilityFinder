package com.availability.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.availability.entity.Event;

@Repository
public class EventsDAOImpl implements EventsDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Event> getEvents() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Event> theQuery = currentSession.createQuery("from Event", Event.class);

		// execute query and get result list
		List<Event> events = theQuery.getResultList();

		// return the results
		return events;

	}

	@Override
	public Event getEvent(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Event theEvent = currentSession.get(Event.class, theId);

		return theEvent;
	}

}
