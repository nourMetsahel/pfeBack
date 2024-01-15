package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Demande;
import com.example.demo.entity.DemandeDocumentAdministratif;
import com.example.demo.entity.Personnel;
import com.example.demo.repository.DemandeRepository;


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/demandes")
public class DemandeController {

	 @Autowired
	    private DemandeRepository demandeRepository;
	    
	   /* @GetMapping("/api/demandes")
	    public String findAllDemandes(Model model) {
	        List<Demande> demandes = demandeRepository.findAllDemandesByMatriculeP(mat);
	        model.addAttribute("demandes", demandes);
	        return "demande-list";
	    }*/

	 @GetMapping("/get/demandesP/{matriculeP}")
	 public List<Demande> getall(@PathVariable String matriculeP) {
	     return this.demandeRepository.findAllDemandesByMatriculeP(matriculeP);
	 }
	 
	/* @GetMapping("/get/demandesC/{matriculeP}")
	 public List<Demande> getall(@PathVariable String matriculeP) {
	     return this.demandeRepository.findAllDemandesByMatriculeP(matriculeP);
	 }
	 */
	 
	 @GetMapping("/get/demandesChef/{matriculeP}")
	 public List<Demande> getchef(@PathVariable String matriculeP) {
	     return this.demandeRepository.findAllDemandesByMatriculeP(matriculeP);
	 }
	 
	/* @GetMapping("/new/{idServiceChef}")
	    public List<Demande> getDemandesByChefService(@PathVariable Long idServiceChef) {
	        // TODO: obtenir l'identifiant du service du chef authentifié
	        Long idServiceChefAuthentifie = ...;
	        return demandeRepository.findAllByChefService(idServiceChefAuthentifie);
	    }*/

	 @GetMapping("/get/demand/{serviceChef}")
	 public List<Demande> getDemandeChef(@PathVariable Long serviceChef) {
	     return this.demandeRepository.findAllDemandesByPersonnel(serviceChef);
	 }
	 @GetMapping("/get/allDemand")
	 public List<Demande> getDemandeAdmin() {
	     return this.demandeRepository.findAllDemandes();
	 }
	 @Transactional
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delete(@PathVariable Long id) {
		 demandeRepository.deleteByIdD(id);
			return ResponseEntity.ok("Deleted");
		}
	 
	 @PutMapping("/update")
		public Demande update(@RequestBody Demande u) {

		    Optional<Demande> p = demandeRepository.findByIdD(u.getIdD());
		    
		    Demande D = p.get();
		        
		           
		            D.setRep(u.getRep());
		            D.setStatut(u.getStatut());
		            D.setGere(u.getGere());
		            
		            
		            Demande updatedPersonnel = demandeRepository.save(D);
		        return updatedPersonnel;
		    
		    }
		
}
