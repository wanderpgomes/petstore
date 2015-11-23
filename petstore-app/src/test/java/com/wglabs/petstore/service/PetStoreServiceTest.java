package com.wglabs.petstore.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.wglabs.petstore.api.PetDto;
import com.wglabs.petstore.model.Pet;
import com.wglabs.petstore.repository.PetRepository;

@RunWith(MockitoJUnitRunner.class)
public class PetStoreServiceTest {
	
	@Mock
	private PetRepository petRepository;
	
	@InjectMocks
	private PetStoreService fixture;
	
	@Test
	public void testCreatePet(){
		
		PetDto petDto = new PetDto();
		petDto.setName("name");
		petDto.setStatus("SOLD");
		
		fixture.createPet(petDto);
		
		verify(petRepository).save(Mockito.any(Pet.class));
	}

}
