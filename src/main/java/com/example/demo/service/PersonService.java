package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import com.example.demo.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	
	public List<Person> findAll(){ 
		logger.info("Find all People!");
		
		List<Person> people = new ArrayList<Person>();
		for (int i = 0; i < 4; i++) {
			Person person = mockPerson(i);
			people.add(person);
		}
		return people;
	}
	
	
	public Person findById(String id) {
		logger.info("Find a Person!");
		
		return Person.builder()
		        .id(counter.incrementAndGet())
		        .firstName("Paulista")
		        .lastName("Pietro")
		        .cep("49160-000")
		        .gender("Masculino")
		        .build();
	}
	
	public Person create(Person person) {
		logger.info("Create a Person!");
		
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating a Person!");
		
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting a Person!");
	}
	
	public Person mockPerson(int i) {
	    return Person.builder()
	        .id(counter.incrementAndGet())
	        .firstName("First name %d".formatted(i))
	        .lastName("Last name %d".formatted(i))
	        .cep("cep %d".formatted(i))
	        .gender("Sex".formatted(i))
	        .build();
	}
}
