package de.primedev.restconsumer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.primedev.restconsumer.model.Todo;

@Service
public class TodoService {


	
	public Todo[] getTodos(String url) {
		Todo[] todo = (new RestTemplate()).getForObject(url, Todo[].class);
		return todo;
	}
}
