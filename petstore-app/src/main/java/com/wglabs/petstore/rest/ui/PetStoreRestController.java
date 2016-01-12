package com.wglabs.petstore.rest.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wglabs.petstore.api.PetDto;
import com.wglabs.petstore.service.IPetStoreService;


@RestController
public class PetStoreRestController {

	@Autowired
	private IPetStoreService petStoreService;
	
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value="/pet", method=RequestMethod.POST)
    public  @ResponseBody PetDto createPet(@RequestBody PetDto request) {
        
		return petStoreService.createPet(request);
		
    }
	
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value="/pet", method=RequestMethod.GET)
    public  @ResponseBody List<PetDto> getPets() {
        
		return petStoreService.findAllPets();
		
    }
	
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value="/pet/{petId}", method=RequestMethod.GET)
    public  @ResponseBody PetDto getPet(@PathVariable Long petId) {
        
		return petStoreService.findPet(petId);
		
    }

}
