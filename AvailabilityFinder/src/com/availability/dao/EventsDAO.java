package com.availability.dao;

import java.util.List;

import com.availability.entity.Event;

public interface EventsDAO {

	public List<Event> getEvents();

	public Event getEvent(int theId);

}
