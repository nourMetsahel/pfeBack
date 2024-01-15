package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DemandeConge;

import com.example.demo.entity.Personnel;

public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Long> {
	
	Optional<DemandeConge>findByIdD(Long id);
	List<DemandeConge> findByPersonnel(Personnel personnel);
	List<DemandeConge> findByMatriculeP(String mat);

}

