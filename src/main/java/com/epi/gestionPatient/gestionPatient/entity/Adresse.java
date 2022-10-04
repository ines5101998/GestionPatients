package com.epi.gestionPatient.gestionPatient.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Adresse {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int codepostal;
	
	private String ville;
	
	private String rue;
	
	@OneToMany(mappedBy = "adresse", cascade = CascadeType.ALL)
	@JsonProperty(access=Access.WRITE_ONLY)
	List<Patient>liste;
}
