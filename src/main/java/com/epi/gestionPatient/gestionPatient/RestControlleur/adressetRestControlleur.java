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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epi.gestionPatient.gestionPatient.entity.Adresse;
import com.epi.gestionPatient.gestionPatient.services.serviceAdresse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("RestapiAdresse")
public class adressetRestControlleur {
	
	@Autowired
	serviceAdresse sa;
	
	@GetMapping("/all")
	public List<Adresse> getAllAdresses() {
		
		return sa.getAllAdresses();
		
	}
	
	@GetMapping("/rechercheParMc/{mc}")
	public List<Adresse> getAllAdressesByMc(@PathVariable("mc") String mot) {
	
		return sa.getAdresseBMC(mot);
	}
	
		
	@PostMapping("/add")
	public void saveAdresse(@Valid @RequestBody Adresse a)
	{
		sa.ajouterAdresse(a);		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAdresse(@PathVariable  int id) 
	{
		sa.supprimerAdresse(id);
	}
	
	@PutMapping("/update")
	public void updateAdresse(@RequestBody Adresse a) 
	{
		saveAdresse(a);		
	}

}
