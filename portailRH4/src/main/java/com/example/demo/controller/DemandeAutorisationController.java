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

import com.example.demo.entity.Demande;
import com.example.demo.entity.DemandeAutorisation;
import com.example.demo.entity.DemandeConge;
import com.example.demo.entity.DemandePret;
import com.example.demo.entity.Personnel;
import com.example.demo.repository.DemandeAutorisationRepository;




	@CrossOrigin("http://localhost:4200/")
	@RestController
	@RequestMapping("/api/autorisation")
	public class DemandeAutorisationController {
		
		@Autowired
		private DemandeAutorisationRepository dao;
		
		
		
		@PostMapping("add")
		public DemandeAutorisation ajout(@RequestBody DemandeAutorisation f) {
			return dao.save(f);
		}
		
			@GetMapping("/get/demande/{mat}")
		    public  Optional<DemandeAutorisation> get(@PathVariable Long mat){
		  	return this.dao.findByIdD(mat);
		    }

			@GetMapping("/get/demandes/{personnel}")
			public List<DemandeAutorisation> get(@PathVariable Personnel personnel) {
			    return this.dao.findByPersonnel(personnel);
			}
			@GetMapping("/get/demandesP/{mat}")
			public List<DemandeAutorisation> getDP(@PathVariable String mat) {
			    return this.dao.findByMatriculeP(mat);
			}
			

			 @PutMapping("/update")
				public DemandeAutorisation update(@RequestBody DemandeAutorisation u) {

				    Optional<DemandeAutorisation> p = dao.findByIdD(u.getIdD());
				    
				    
				    DemandeAutorisation D = p.get();
				        
				        
				            D.setRaison(u.getRaison());
				           
				            D.setTypeA(u.getTypeA());
				            
				            
				            DemandeAutorisation updatedPersonnel = dao.save(D);
				        return updatedPersonnel;
				    
				    }
			 
			 @PutMapping("/update1")
				public DemandeAutorisation update1(@RequestBody DemandeAutorisation u) {

				    Optional<DemandeAutorisation> p = dao.findByIdD(u.getIdD());
				    
				    DemandeAutorisation D = p.get();
				        
				           
				            D.setRep(u.getRep());
				            D.setStatut(u.getStatut());
				            D.setGere(u.getGere());
				            
				            
				            DemandeAutorisation updatedPersonnel = dao.save(D);
				        return updatedPersonnel;
				    
				    }


	}

