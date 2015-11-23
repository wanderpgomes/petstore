package com.wglabs.petstore.rest.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wglabs.petstore.api.PetDto;
import com.wglabs.petstore.service.IPetStoreService;

@RestController
public class PetStoreRestController {

	@Autowired
	private IPetStoreService petStoreService;
	
	@RequestMapping(value="/pet", method=RequestMethod.POST)
    public PetDto createPet(@RequestBody PetDto request) {
        
		return petStoreService.createPet(request);
		
    }

}
