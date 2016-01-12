package com.wglabs.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.wglabs.petstore.api.PetDto;
import com.wglabs.petstore.model.Pet;
import com.wglabs.petstore.repository.PetRepository;

@Service
public class PetStoreService implements  IPetStoreService{
	
	@Autowired
	private PetRepository petRepository;
	
	private PetDtoConverter converter = new PetDtoConverter();

	@Override
	public PetDto createPet(PetDto petDto) {		
		
		Pet pet = petRepository.save(converter.convert(petDto));
		return converter.reverse().convert(pet);
	}
	
	@Override
	public List<PetDto> findAllPets() {		
		
		Iterable<Pet> pets = petRepository.findAllByOrderByIdAsc();
		return (pets == null) ? new ArrayList<PetDto>() : Lists.newArrayList(converter.reverse().convertAll(pets));	
	}

	@Override
	public PetDto findPet(Long id) {
		
		Pet pet = petRepository.findOne(id);
		return converter.reverse().convert(pet);
	}

	@Override
	public void deletePet(Long id) {
		
		petRepository.delete(id);
	}

}
