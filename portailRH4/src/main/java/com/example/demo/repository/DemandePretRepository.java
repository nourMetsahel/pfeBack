package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.DemandePret;
import com.example.demo.entity.Personnel;


public interface DemandePretRepository extends JpaRepository<DemandePret,Long> {
	
	Optional<DemandePret> findByIdD(Long id);
	List<DemandePret> findByPersonnel(Personnel personnel);
	List<DemandePret> findByMatriculeP(String mat);
	
	   // List<DemandePret> findByPersonnelOrderByTypeDAsc(Personnel personnel);
	


}
