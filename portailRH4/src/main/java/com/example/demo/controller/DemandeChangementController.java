package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DemandeAutorisation;
import com.example.demo.entity.DemandeChangementSP;
import com.example.demo.entity.DemandePret;
import com.example.demo.entity.Personnel;
import com.example.demo.repository.DemandeChangementRepository;



	@CrossOrigin("http://localhost:4200/")
	@RestController
	@RequestMapping("/api/changement")
	public class DemandeChangementController {
		
		@Autowired
		private DemandeChangementRepository dao;
		
		
		
		@PostMapping("add")
		public DemandeChangementSP ajout(@RequestBody DemandeChangementSP f) {
			return dao.save(f);
		}
		
			@GetMapping("/get/demande/{mat}")
		    public  Optional<DemandeChangementSP> get(@PathVariable Long mat){
		  	return this.dao.findByIdD(mat);
		    }

			@GetMapping("/get/demandes/{personnel}")
			public List<DemandeChangementSP> get(@PathVariable Personnel personnel) {
			    return this.dao.findByPersonnel(personnel);
			}
			
			@GetMapping("/get/demandesP/{mat}")
			public List<DemandeChangementSP> getDP(@PathVariable String mat) {
			    return this.dao.findByMatriculeP(mat);
			}
			
			
			@PutMapping("/update")
			public DemandeChangementSP update(@RequestBody DemandeChangementSP u) {

			    Optional<DemandeChangementSP> p = dao.findByIdD(u.getIdD());
			    
			    
			    DemandeChangementSP D = p.get();
			        
			        
			            D.setRaison(u.getRaison());
			            
			            
			            D.setTypeCH(u.getTypeCH());
			            D.setModification(u.getModification());
			            
			            
			            
			            DemandeChangementSP updatedPersonnel = dao.save(D);
			        return updatedPersonnel;
			    
			    }
			
			 @PutMapping("/update1")
				public DemandeChangementSP update1(@RequestBody DemandeChangementSP u) {

				    Optional<DemandeChangementSP> p = dao.findByIdD(u.getIdD());
				    
				    DemandeChangementSP D = p.get();
				        
				           
				            D.setRep(u.getRep());
				            D.setStatut(u.getStatut());
				            D.setGere(u.getGere());
				            
				            
				            DemandeChangementSP updatedPersonnel = dao.save(D);
				        return updatedPersonnel;
				    
				    }


	}
