package com.epi.gestionPatient.gestionPatient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //permet de remplacer tous les getters et setters des attributs.
@AllArgsConstructor // permet de remplacer le constructeur par défaut
@NoArgsConstructor // permet de remplacer le constructeur avec paramètres
@Entity
public class Patient {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String prenom;
	private Integer numtel;
	private String photo;
	
	@ManyToOne
	private Service service;

	@ManyToOne
	private Adresse adresse;

}
