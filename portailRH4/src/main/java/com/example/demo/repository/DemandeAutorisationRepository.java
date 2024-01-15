package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DemandeAutorisation;

import com.example.demo.entity.Personnel;

public interface DemandeAutorisationRepository extends JpaRepository<DemandeAutorisation, Long> {
	
	Optional<DemandeAutorisation>findByIdD(Long id);
	List<DemandeAutorisation> findByPersonnel(Personnel personnel);
	List<DemandeAutorisation> findByMatriculeP(String mat);

}

