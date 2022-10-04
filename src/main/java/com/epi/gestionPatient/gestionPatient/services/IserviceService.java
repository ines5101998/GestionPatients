package com.epi.gestionPatient.gestionPatient.services;

import java.util.List;

import com.epi.gestionPatient.gestionPatient.entity.Service;

public interface IserviceService {
	
	public void ajouterService(Service s);
	public List<Service> getAllServices();
	public Service getServiceById(int Id);
	public List<Service> getServiceBMC(String motcle);
	public void supprimerService(int Id);
	public void mettreAJourService(Service s);

}
