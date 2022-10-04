package com.epi.gestionPatient.gestionPatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epi.gestionPatient.gestionPatient.entity.Adresse;

@Repository
public interface AdresseRepository  extends JpaRepository<Adresse, Integer>{
	
	@Query("select a from Adresse a  where a.ville like %:x%")
	List<Adresse> rechercherParMc(@Param("x") String mc);


}
