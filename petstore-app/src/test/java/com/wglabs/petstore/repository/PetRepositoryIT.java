package com.wglabs.petstore.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wglabs.petstore.model.Pet;
import com.wglabs.petstore.spring.config.DataSourceConfiguration;
import com.wglabs.petstore.spring.config.PersistenceConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfiguration.class, PersistenceConfiguration.class})
public class PetRepositoryIT {
	
	@Autowired
	protected PetRepository petRepository;
	
	@Test
	public void testSavePet(){
		Pet pet = createPet("pet 1", "available");
		
		Pet result = petRepository.save(pet);
		
		assertNotNull(result.getId());
	}
	
	@Test
	public void testFindAllPets(){
		Pet pet1 = createPet("pet 1", "available");
		Pet pet2 = createPet("pet 2", "sold");

		petRepository.save(pet1);
		petRepository.save(pet2);
		
		
		Iterable<Pet> result = petRepository.findAllByOrderByIdAsc();
		
		Iterator<Pet> iterator = result.iterator();
		
		assertTrue(iterator.hasNext());
		assertEquals(pet1.getName(), iterator.next().getName());
		assertEquals(pet2.getName(), iterator.next().getName());
	}
	
	@Test
	public void testFindAllPets_noPetFound(){
		Iterable<Pet> result = petRepository.findAllByOrderByIdAsc();
		
		assertNotNull(result);
		assertFalse(result.iterator().hasNext());
	}
	
	@After
	public void tearDown(){
		petRepository.deleteAll();
	}
	
	@Before
	public void setUp(){
		petRepository.deleteAll();
	}
	
	private Pet createPet(String name, String status){
		Pet pet = new Pet();
		pet.setName(name);
		pet.setStatus(status);
		
		return pet;
	}

}
