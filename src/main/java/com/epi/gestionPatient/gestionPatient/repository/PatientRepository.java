package com.epi.gestionPatient.gestionPatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epi.gestionPatient.gestionPatient.entity.Patient;

@Repository
public interface PatientRepository  extends JpaRepository<Patient, Integer>{
	
	@Query("select a from Patient a  where a.nom like %:x%")
	List<Patient> rechercherParMc(@Param("x") String mc);

}
