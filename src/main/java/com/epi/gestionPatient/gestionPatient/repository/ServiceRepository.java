package com.epi.gestionPatient.gestionPatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epi.gestionPatient.gestionPatient.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
	
	@Query("select a from Service a  where a.nom like %:x%")
	List<Service> rechercherParMc(@Param("x") String mc);

}
