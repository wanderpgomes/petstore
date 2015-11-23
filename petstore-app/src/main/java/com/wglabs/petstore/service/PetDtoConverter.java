package com.wglabs.petstore.service;

import com.google.common.base.Converter;
import com.wglabs.petstore.api.PetDto;
import com.wglabs.petstore.model.Pet;

public class PetDtoConverter extends Converter<PetDto, Pet>{

	@Override
	protected PetDto doBackward(Pet pet) {
		PetDto petDto = new PetDto();
		petDto.setId(pet.getId());
		petDto.setName(pet.getName());
		petDto.setStatus(pet.getStatus());
		return petDto;
	}

	@Override
	protected Pet doForward(PetDto petDto) {
		Pet pet = new Pet();
		pet.setId(petDto.getId());
		pet.setName(petDto.getName());
		pet.setStatus(petDto.getStatus());
		return pet;
	}

}
