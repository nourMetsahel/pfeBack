package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DemandeMutation;
import com.example.demo.entity.DemandePret;
import com.example.demo.entity.Personnel;

public interface DemandeMutationRepository extends JpaRepository<DemandeMutation, Long> {
	
	Optional<DemandeMutation>findByIdD(Long id);
	List<DemandeMutation> findByPersonnel(Personnel personnel);
	List<DemandeMutation> findByMatriculeP(String mat);

}
