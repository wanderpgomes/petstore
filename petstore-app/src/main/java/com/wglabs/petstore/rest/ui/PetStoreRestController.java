package com.wglabs.petstore.rest.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
