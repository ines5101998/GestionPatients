package com.epi.gestionPatient.gestionPatient.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.epi.gestionPatient.gestionPatient.entity.Patient;

public interface IservicePatient {
	
	public void ajouterPatient(Patient e,MultipartFile mf) throws IOException ;
	public List<Patient> getAllPatients();
	public Patient getPatientById(int Id);
	public List<Patient> getPatientBMC(String motcle);
	public void supprimerPatient(int Id)throws IOException;
	public void mettreAJourPatient(Patient e);
	String saveImage(MultipartFile mf)throws IOException ;
	byte[]  getImage(int id)throws IOException;

}
