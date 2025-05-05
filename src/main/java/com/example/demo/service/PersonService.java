package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;


@Service
public class PersonService {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	PersonRepository repository;
	
	
	public List<Person> findAll(){ 
		logger.info("Find all People!");
		return repository.findAll();	
	}
	
	
	public Person findById(Long id) {
		logger.info("Find a Person!");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record founds for this id! Please, try another id."));
	}
	
	public Person create(Person person) {
		logger.info("Create a Person!");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating a Person!");
		
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record founds for this id! Please, try another id."));
		
		person.setFirstName(entity.getFirstName());
        person.setLastName(entity.getLastName());
        person.setCep(entity.getCep());
        person.setGender(entity.getGender());
        
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting a Person!");
		
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record founds for this id! Please, try another id."));
		
		repository.delete(entity);
	}
	
}
