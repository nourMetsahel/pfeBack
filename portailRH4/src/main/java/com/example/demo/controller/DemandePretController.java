package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DemandeMutation;
import com.example.demo.entity.DemandePret;
import com.example.demo.entity.Personnel;
import com.example.demo.repository.DemandePretRepository;
import com.example.demo.repository.UserRepository;



@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/pret")
public class DemandePretController {
	
	@Autowired
	private DemandePretRepository dao;
	
	
	
	@PostMapping("add")
	public DemandePret ajout(@RequestBody DemandePret f) {
		return dao.save(f);
	}
	
		@GetMapping("/get/demande/{mat}")
	    public  Optional<DemandePret> get(@PathVariable Long mat){
	  	return this.dao.findByIdD(mat);
	    }

		@GetMapping("/get/demandes/{personnel}")
		public List<DemandePret> get0(@PathVariable Personnel personnel) {
		    return this.dao.findByPersonnel(personnel);
		}
		
		@GetMapping("/get/demandesP/{mat}")
		public List<DemandePret> getDP(@PathVariable String mat) {
		    return this.dao.findByMatriculeP(mat);
		}
		@PutMapping("/update")
		public DemandePret update(@RequestBody DemandePret u) {

		    Optional<DemandePret> p = dao.findByIdD(u.getIdD());
		    
		    
		    DemandePret D = p.get();
		        
		        
		            D.setRaison(u.getRaison());
		          
		            D.setTypeP(u.getTypeP());
		            D.setMontant(u.getMontant());
		           
		            
		            
		            DemandePret updatedPersonnel = dao.save(D);
		        return updatedPersonnel;
		    
		    }
		@PutMapping("/update1")
		public DemandePret update1(@RequestBody DemandePret u) {

		    Optional<DemandePret> p = dao.findByIdD(u.getIdD());
		    
		    DemandePret D = p.get();
		        
		           
		            D.setRep(u.getRep());
		            D.setStatut(u.getStatut());
		            D.setGere(u.getGere());
		            
		            
		            DemandePret updatedPersonnel = dao.save(D);
		        return updatedPersonnel;
		    
		    }

}
