package com.wglabs.petstore.service;

import java.util.List;

import com.wglabs.petstore.api.PetDto;

public interface IPetStoreService {
	
	public PetDto createPet(PetDto pet);

	public List<PetDto> findAllPets();
	
	public PetDto findPet(Long id);

}
