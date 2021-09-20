package com.dio.springboot.service;

import com.dio.springboot.exception.DogNotFoundException;
import com.dio.springboot.model.Dog;
import com.dio.springboot.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    @Autowired
    private DogRepository repository;

    public List<Dog> findAll() {
        return repository.findAll();
    }

    public Dog findById(String id) {
        final Optional<Dog> dog = repository.findById(id);
        if (dog.isPresent()){
            return dog.get();
        }else{
            throw new DogNotFoundException();
        }
    }

    public Dog save(Dog jedi) {
        return repository.save(jedi);
    }

    public Dog update(String id, Dog dto) {

        final Optional<Dog> dogEntity = repository.findById(id);
        final Dog dog;
        if (dogEntity.isPresent()) {
            dog = dogEntity.get();
        }else {
            throw new DogNotFoundException();
        }
        dog.setNome(dto.getNome());
        dog.setImg(dto.getImg());

        return repository.save(dog);

    }

    public void delete(String id) {
        final Dog dog = this.findById(id);

        repository.delete(dog);

    }

}
