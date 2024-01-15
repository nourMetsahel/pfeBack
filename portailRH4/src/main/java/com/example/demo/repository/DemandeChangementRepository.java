package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DemandeChangementSP;
import com.example.demo.entity.Personnel;

public interface DemandeChangementRepository extends JpaRepository<DemandeChangementSP, Long> {
	
	Optional<DemandeChangementSP> findByIdD(Long id);
	List<DemandeChangementSP> findByPersonnel(Personnel personnel);
	List<DemandeChangementSP> findByMatriculeP(String mat);

}
