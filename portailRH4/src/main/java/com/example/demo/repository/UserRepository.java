package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Demande;
import com.example.demo.entity.Personnel;



public interface UserRepository extends JpaRepository<Personnel, Long>{
	 Optional<Personnel> findByNom(String username);
	 Optional<Personnel> findByMatriculeP(String matricule);
	 Optional<Personnel> deleteByMatriculeP(String mat);
	 Optional<Personnel> findByIdP(Long id);
	 Optional<Personnel> deleteByIdP(Long id);
	 
	 @Query("SELECT p FROM Personnel p WHERE p.role.id = :roleId")
	 List<Personnel> findAllPersonnelsByRole(@Param("roleId") Integer roleId);
	 
	 
	 
	 
	
	 
	 
	  

}
