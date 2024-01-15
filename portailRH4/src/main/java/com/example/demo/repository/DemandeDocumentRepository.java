package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DemandeDocumentAdministratif;
import com.example.demo.entity.DemandePret;
import com.example.demo.entity.Personnel;

public interface DemandeDocumentRepository extends JpaRepository<DemandeDocumentAdministratif, Long> {
	
	Optional<DemandeDocumentAdministratif>findByIdD(Long id);
	List<DemandeDocumentAdministratif> findByPersonnel(Personnel personnel);
	List<DemandeDocumentAdministratif> findByMatriculeP(String mat);
}
