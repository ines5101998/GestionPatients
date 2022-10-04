package com.epi.gestionPatient.gestionPatient.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epi.gestionPatient.gestionPatient.entity.Service;
import com.epi.gestionPatient.gestionPatient.repository.ServiceRepository;


@org.springframework.stereotype.Service
public class serviceService implements IserviceService{
	
	@Autowired
	ServiceRepository adr;

	@Override
	public void ajouterService(Service a) {

		adr.save(a);
	}

	@Override
	public List<Service> getAllServices() {

		return adr.findAll();
	}

	@Override
	public Service getServiceById(int Id) {

		return adr.findById(Id).get();
	}

	@Override
	public List<Service> getServiceBMC(String motcle) {

		return adr.rechercherParMc(motcle);
	}

	@Override
	public void supprimerService(int Id) {
		
		adr.deleteById(Id);
		
	}

	@Override
	public void mettreAJourService(Service a) {

		adr.save(a);

	}

}
