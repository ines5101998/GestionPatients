package com.epi.gestionPatient.gestionPatient.controlleur;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.epi.gestionPatient.gestionPatient.entity.Patient;
import com.epi.gestionPatient.gestionPatient.entity.Service;
import com.epi.gestionPatient.gestionPatient.services.serviceAdresse;
import com.epi.gestionPatient.gestionPatient.services.servicePatient;
import com.epi.gestionPatient.gestionPatient.services.serviceService;






@Controller
@RequestMapping("/apiPatient")
public class PatientControlleur {
	
	@Autowired
	servicePatient se;
	
	@Autowired
	serviceService ss;
	
	@Autowired
	serviceAdresse ad;
	
	@GetMapping("/all")
	public String getAllPatient(Model m) {
		
		List<Patient> Patient = se.getAllPatients();
		m.addAttribute("listePatient", Patient);
		return "vuePatient";
		
	}
	

	@GetMapping("/rechercheParMc")
	public String getAllPatientByMc(@RequestParam String mc, Model m) {
		
		List<Patient> Patient = se.getPatientBMC(mc);
		m.addAttribute("listePatient", Patient);
		return "vuePatient";

	}
	

	@GetMapping("/add")
	public String ajouter( Model m) {
		
		m.addAttribute("services",ss.getAllServices());
		m.addAttribute("adresses",ad.getAllAdresses());
		
		return "ajoutPatient";
		
	}
	
	@PostMapping("/addP")
	public String ajouterPatient(@ModelAttribute Patient e, @RequestParam("file") MultipartFile mf,Model m, @RequestParam int idService) throws IOException {

		Integer id = e.getId();
		Service service = ss.getServiceById(idService);
		e.setService(service);
		se.ajouterPatient(e, mf);
		
		if(id!=null) {
			
	     return "redirect:/apiPatient/all";
			
		}
		
		else {
			
		m.addAttribute("message", "ajout avec succes");
		m.addAttribute("services",ss.getAllServices());
		m.addAttribute("adresses",ad.getAllAdresses());

		return "ajoutPatient";
		
	}
}
	
	@GetMapping("/update/{id}")
	
	public String modifierPatient(Model m,@PathVariable int id) {
		
		m.addAttribute("services",ss.getAllServices());
		m.addAttribute("adresses",ad.getAllAdresses());
		m.addAttribute("patient",se.getPatientById(id));

		
		return "ajoutPatient";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerPatient(@PathVariable int id) throws IOException{
		
		se.supprimerPatient(id);
		return "redirect:/apiPatient/all";
	}
	
}