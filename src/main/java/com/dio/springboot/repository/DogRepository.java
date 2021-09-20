package com.dio.springboot.repository;

import com.dio.springboot.model.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DogRepository extends MongoRepository<Dog, String>{
}
