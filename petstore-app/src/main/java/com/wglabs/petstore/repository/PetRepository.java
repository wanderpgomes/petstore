package com.wglabs.petstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.wglabs.petstore.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
