package com.epi.gestionPatient.gestionPatient.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epi.gestionPatient.gestionPatient.entity.Service;
import com.epi.gestionPatient.gestionPatient.services.serviceService;

@Controller
@RequestMapping("/apiservice")
public class ServiceContolleur {
	
	@Autowired
	serviceService ss;
	
	@GetMapping("/all")
	public String getAllService(Model m) {
		
		List<Service> Service = ss.getAllServices();
		m.addAttribute("listeService", Service);
		return "vueService";
		
	}
	

	@GetMapping("/rechercheParMc")
	public String getAllServiceByMc(@RequestParam String mc, Model m) {
		
		List<Service> Service = ss.getServiceBMC(mc);
		m.addAttribute("listeService", Service);
		return "vueService";

	}
	

	@GetMapping("/add")
	public String ajouter( Model m) {
		
		m.addAttribute("services",ss.getAllServices());
		
		return "ajoutService";
		
	}
	
	@PostMapping("/add")
	public String ajouterService(Service e, Model m) {

		ss.ajouterService(e);
		
		return "redirect:/apiservice/all";
		
	}
	
	@GetMapping("/update/{id}")
	
	public String modifierService(Model m,@PathVariable int id) {
		
		m.addAttribute("service",ss.getServiceById(id));

		
		return "ajoutService";
	}
	@GetMapping("/delete/{id}")
	public String supprimerService(@PathVariable int id) {
		
		ss.supprimerService(id);
		return "redirect:/apiservice/all";
	}
	
}