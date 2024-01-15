package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Demande;


public interface DemandeRepository extends JpaRepository<Demande, Long> {
	
	@Query("SELECT d FROM Demande d WHERE d.matriculeP = :matriculeP ORDER BY d.idD DESC")
	List<Demande> findAllDemandesByMatriculeP(@Param("matriculeP") String matriculeP);
	
	
	@Query("SELECT d FROM Demande d WHERE d.personnel.service.idService = :serviceChef AND (d.typeD = 'autorisation' OR d.typeD = 'conge' OR d.typeD = 'mutation') ORDER BY d.idD DESC")
	List<Demande> findAllDemandesByPersonnel(@Param("serviceChef") Long serviceChef);


	
	@Query("SELECT d FROM Demande d  ORDER BY d.idD DESC")
	List<Demande> findAllDemandes();
	

	Optional<Demande> deleteByIdD(Long id);
	
	Optional<Demande> findByIdD(Long id);
	


	
}
