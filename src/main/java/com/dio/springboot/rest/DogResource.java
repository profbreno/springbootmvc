package com.dio.springboot.rest;

import com.dio.springboot.model.Dog;
import com.dio.springboot.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DogResource {
    @Autowired
    private DogService service;

    @GetMapping("/dog")
    public List<Dog> getAllDog(){
        return service.findAll();
    }

    @GetMapping("/dog/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable("id") String id) {
        final Dog dog = service.findById(id);
        return ResponseEntity.ok(dog);
    }

    @PostMapping("/dog")
    @ResponseStatus(HttpStatus.CREATED)
    public Dog insert(@Valid @RequestBody Dog dog){
        return service.save(dog);
    }

    @PutMapping("/dog/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable("id") String id, @Valid @RequestBody Dog dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/dog/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDog(@PathVariable("id") String id) {
        service.delete(id);
    }
}