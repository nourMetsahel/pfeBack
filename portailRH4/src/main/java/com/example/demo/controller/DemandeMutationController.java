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

import com.example.demo.entity.DemandeDocumentAdministratif;
import com.example.demo.entity.DemandeMutation;
import com.example.demo.entity.DemandePret;
import com.example.demo.entity.Personnel;
import com.example.demo.repository.DemandeMutationRepository;


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/mutation")
public class DemandeMutationController {
	
	@Autowired
	private DemandeMutationRepository dao;
	
	
	
	@PostMapping("add")
	public DemandeMutation ajout(@RequestBody DemandeMutation f) {
		return dao.save(f);
	}
	
		@GetMapping("/get/demande/{mat}")
	    public  Optional<DemandeMutation> get(@PathVariable Long mat){
	  	return this.dao.findByIdD(mat);
	    }

		@GetMapping("/get/demandes/{personnel}")
		public List<DemandeMutation> get(@PathVariable Personnel personnel) {
		    return this.dao.findByPersonnel(personnel);
		}
		
		@GetMapping("/get/demandesP/{mat}")
		public List<DemandeMutation> getDP(@PathVariable String mat) {
		    return this.dao.findByMatriculeP(mat);
		}
		@PutMapping("/update")
		public DemandeMutation update(@RequestBody DemandeMutation u) {

		    Optional<DemandeMutation> p = dao.findByIdD(u.getIdD());
		    
		    
		    DemandeMutation D = p.get();
		        
		        
		            D.setRaison(u.getRaison());
		            D.setTypeM(u.getTypeM());
		            D.setPosteS(u.getPosteS());
		           
		            
		            
		            DemandeMutation updatedPersonnel = dao.save(D);
		        return updatedPersonnel;
		    
		    }
		 @PutMapping("/update1")
			public DemandeMutation update1(@RequestBody DemandeMutation u) {

			    Optional<DemandeMutation> p = dao.findByIdD(u.getIdD());
			    
			    DemandeMutation D = p.get();
			        
			           
			            D.setRep(u.getRep());
			            D.setStatut(u.getStatut());
			            D.setGere(u.getGere());
			            
			            
			            DemandeMutation updatedPersonnel = dao.save(D);
			        return updatedPersonnel;
			    
			    }
}
