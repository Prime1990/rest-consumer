package de.primedev.restconsumer.mongo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.primedev.restconsumer.model.Todo;

public interface CustomerRepository extends MongoRepository<Todo, String> {

    public List<Todo> findByUserId(String userId);
    public Optional<Todo> findById(String Id);
    
}