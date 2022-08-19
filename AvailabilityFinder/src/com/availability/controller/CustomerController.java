package com.availability.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.availability.entity.Customer;
import com.availability.entity.Event;
import com.availability.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	public static int currentUser;

	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;

	// @Autowired
	// private EventService eventService;

	@RequestMapping("/home")
	public String listHome(Model theModel) {

		// get customers from the SERVICE not dao
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "home";
	}

	@PostMapping("/validateCustomer")
	public String validateCustomer(@ModelAttribute("customer") Customer theCustomer) {
		if (customerService.validateCustomer(theCustomer) != null) {

			Customer validCustomer = customerService.getCustomerByEmail(theCustomer.getEmail());

			currentUser = validCustomer.getId();
			return "redirect:/customer/home";
		} else {
			return "redirect:/customer/login";
		}
	}

	@GetMapping("/login")
	public String showFormForLogin(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "login";
	}

	@GetMapping("/register")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "register";
	}

	@GetMapping("/nav")
	public String nav(Model theModel) {
		// System.out.println("test 1");
		return "nav";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save the customer using our service
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/users";
	}

	@RequestMapping("/events")
	public String eventsCustomers(Model theModel) {

		List<Event> userEvents = customerService.getCustomerEvents(currentUser);

		// add the customers to the model
		theModel.addAttribute("userEvents", userEvents);

		List<Event> nonUserEvents = customerService.getNonUserEvents(currentUser);

		theModel.addAttribute("nonUserEvents", nonUserEvents);

		return "events";
	}

	@RequestMapping("/users")
	public String usersCustomers(Model theModel) {

		// get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "users";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "register";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		// get the customer from our service
		customerService.deleteCustomer(theId);

		return "redirect:/customer/users";
	}

	@GetMapping("/testrelationship")
	public String testrelationship(@RequestParam("eventId") int eId) {
		// many to many step 2, hard code the details to add
		// get these from session or security

		customerService.updateCustomerEventList(currentUser, eId);

		// customerService.updateCustomerEventList(customer_Id, event_Id);

		return "redirect:/customer/events";
	}

	@GetMapping("/deletetestrelationship")
	public String deletetestrelationship(@RequestParam("eventId") int eId) {
		// many to many step 2, hard code the details to add
		// get these from session or security

		customerService.removeCustomerEventList(currentUser, eId);

		// customerService.updateCustomerEventList(customer_Id, event_Id);

		return "redirect:/customer/events";
	}

}
