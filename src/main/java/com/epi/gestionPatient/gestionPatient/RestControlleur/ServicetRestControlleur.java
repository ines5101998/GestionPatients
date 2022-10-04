package com.epi.gestionPatient.gestionPatient.RestControlleur;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epi.gestionPatient.gestionPatient.entity.Service;
import com.epi.gestionPatient.gestionPatient.services.serviceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("RestapiService")
public class ServicetRestControlleur {
	
	@Autowired
	serviceService sg;
	
	@GetMapping("/all")
	public List<Service> getAllServices() {
		
		return sg.getAllServices();
		
	}
	
	@GetMapping("/rechercheParMc/{mc}")
	public List<Service> getAllServicesByMc(@PathVariable("mc") String mot) {
	
		return sg.getServiceBMC(mot);
	}
	
		
	@PostMapping("/add")
	public void saveService(@Valid @RequestBody Service g) 
	{
		 sg.ajouterService(g);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteService(@PathVariable  int id)
	{
		sg.supprimerService(id);

	}
	
	@PutMapping("/update")
	public void updateService(@RequestBody Service g)
	{
		saveService(g);		
	}

}
