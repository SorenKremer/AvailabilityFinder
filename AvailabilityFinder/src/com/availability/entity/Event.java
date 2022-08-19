package com.availability.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventId")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "location")
	private String location;

	@Column(name = "time")
	private String time;

	@ManyToMany
	@JoinTable(name = "customer_event", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
	List<Customer> eventsCustomers;

	public List<Customer> getEventsCustomers() {
		return eventsCustomers;
	}

	public void setEventsCustomers(List<Customer> eventsCustomers) {
		this.eventsCustomers = eventsCustomers;
	}

	public Event() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", description=" + description + ", location=" + location + ", time=" + time
				+ ", eventsCustomers=" + eventsCustomers + "]";
	}

}
