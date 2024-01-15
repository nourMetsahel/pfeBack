package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Personnel;
import com.example.demo.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
	
	
	//Optional<Service> findByMatriculChef(String matriculeChef);
	
	//Optional<Service> deleteByMatriculChef(String matriculeChef);
	
	Optional<Service> deleteByPersonnel(Personnel id);
	
	Optional<Service> findByIdService(Long id);
	
	Optional<Service> deleteByIdService(Long id);
	
	Optional<Service> findByPersonnel(Personnel id);
}
