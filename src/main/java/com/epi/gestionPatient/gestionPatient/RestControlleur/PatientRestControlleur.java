package com.epi.gestionPatient.gestionPatient.RestControlleur;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.epi.gestionPatient.gestionPatient.entity.Patient;
import com.epi.gestionPatient.gestionPatient.services.servicePatient;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("RestapiPatient")
public class PatientRestControlleur {
	
	@Autowired
	servicePatient se;
	
	@GetMapping("/all")
	public List<Patient> getAllPatients() {
		
		return se.getAllPatients();
		
	}
	
	@GetMapping("/rechercheParMc/{mc}")
	public List<Patient> getAllPatientsByMc(@PathVariable("mc") String mot) {
	
		return se.getPatientBMC(mot);	
	}
	

	@GetMapping(path="/getImage/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable("id") int id)throws IOException {
		return se.getImage(id);
	}
	
	@PostMapping("/add")
	public void savePatient(@Valid @RequestParam("Patient") String e ,@RequestParam("file") MultipartFile mf) throws IOException 
	{
		Patient ee = new ObjectMapper().readValue(e, Patient.class);
		se.ajouterPatient(ee, mf);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePatient(@PathVariable  int id) throws IOException 
	{
		se.supprimerPatient(id);
	}
	
	@PutMapping("/update")
	public void updatePatient(@RequestParam("Patient") String e ,@RequestParam("file") MultipartFile mf) throws IOException 
	{
		savePatient(e, mf);
		
	}

}
