package com.epi.gestionPatient.gestionPatient.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epi.gestionPatient.gestionPatient.entity.Adresse;
import com.epi.gestionPatient.gestionPatient.services.serviceAdresse;

@CrossOrigin(origins = "http://localhost:8282")
@Controller  //controlleur de spring
@RequestMapping("/apiadresse")//indique la route de ce controlleur
public class adresseControlleur {
	
	@Autowired
	serviceAdresse sa;
	
	@GetMapping("/all")//model:nous permettra d’envoyer des attributs à la vue
	public String getAllAdresse(Model m) {
		
		List<Adresse> adresse = sa.getAllAdresses();
		m.addAttribute("listeAdresse", adresse);
		return "vueAdresse";
		
	}
	

	@GetMapping("/rechercheParMc")
	public String getAllCategoryByMc(@RequestParam String mc, Model m) {
		
		List<Adresse> adresse = sa.getAdresseBMC(mc);
		m.addAttribute("listeAdresse", adresse);
		return "vueAdresse";

	}
	

	@GetMapping("/add")
	public String ajouter( Model m) {
		
		m.addAttribute("adresses",sa.getAllAdresses());
		
		return "ajoutAdresse";
		
	}
	
	@PostMapping("/add")
	public String ajouteradresse(Adresse a, Model m) {

		sa.ajouterAdresse(a);
		
		return "redirect:/apiadresse/all";
		
	}
	
	@GetMapping("/update/{id}")
	
	public String modifieradresse(Model m,@PathVariable int id) {
		
		m.addAttribute("adresse",sa.getAdresseById(id));

		
		return "ajoutAdresse";
	}
	@GetMapping("/delete/{id}")
	public String supprimeradresse(@PathVariable int id) {
		sa.supprimerAdresse(id);
		
		return "redirect:/apiadresse/all";
	}
	
}