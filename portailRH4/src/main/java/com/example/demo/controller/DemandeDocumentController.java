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

import com.example.demo.entity.DemandeConge;
import com.example.demo.entity.DemandeDocumentAdministratif;
import com.example.demo.entity.DemandePret;
import com.example.demo.entity.Personnel;
import com.example.demo.repository.DemandeDocumentRepository;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/document")
public class DemandeDocumentController {
	
	@Autowired
	private DemandeDocumentRepository dao;
	
	
	
	@PostMapping("add")
	public DemandeDocumentAdministratif ajout(@RequestBody DemandeDocumentAdministratif f) {
		return dao.save(f);
	}
	
		@GetMapping("/get/demande/{mat}")
	    public  Optional<DemandeDocumentAdministratif> get(@PathVariable Long mat){
	  	return this.dao.findByIdD(mat);
	    }

		@GetMapping("/get/demandes/{personnel}")
		public List<DemandeDocumentAdministratif> get(@PathVariable Personnel personnel) {
		    return this.dao.findByPersonnel(personnel);
		}
		
		@GetMapping("/get/demandesP/{mat}")
		public List<DemandeDocumentAdministratif> getDP(@PathVariable String mat) {
		    return this.dao.findByMatriculeP(mat);
		}
		@PutMapping("/update")
		public DemandeDocumentAdministratif update(@RequestBody DemandeDocumentAdministratif u) {

		    Optional<DemandeDocumentAdministratif> p = dao.findByIdD(u.getIdD());
		    
		    
		    DemandeDocumentAdministratif D = p.get();
		        
		        
		            D.setRaison(u.getRaison());
		            
		            D.setTypeDA(u.getTypeDA());
		           
		            
		            
		            DemandeDocumentAdministratif updatedPersonnel = dao.save(D);
		        return updatedPersonnel;
		    
		    }
		 @PutMapping("/update1")
			public DemandeDocumentAdministratif update1(@RequestBody DemandeDocumentAdministratif u) {

			    Optional<DemandeDocumentAdministratif> p = dao.findByIdD(u.getIdD());
			    
			    DemandeDocumentAdministratif D = p.get();
			        
			           
			            D.setRep(u.getRep());
			            D.setStatut(u.getStatut());
			            D.setGere(u.getGere());
			            
			            
			            DemandeDocumentAdministratif updatedPersonnel = dao.save(D);
			        return updatedPersonnel;
			    
			    }
}

