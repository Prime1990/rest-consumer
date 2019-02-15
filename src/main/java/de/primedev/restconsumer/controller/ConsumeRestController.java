package de.primedev.restconsumer.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.primedev.restconsumer.model.Todo;
import de.primedev.restconsumer.mongo.CustomerRepository;
import de.primedev.restconsumer.service.TodoService;

@Controller
public class ConsumeRestController {

	@Autowired
	TodoService todoService;
	
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String showRestResults() {
		Todo[] todos = todoService.getTodos("https://jsonplaceholder.typicode.com/todos");
		
		
		repository.deleteAll();
		
		for (Todo todo : todos) {
			repository.save(todo);
		}
		
		return Arrays.toString(repository.findByUserId("2").toArray());
	}
	
}
