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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Personnel;
import com.example.demo.entity.Service;
import com.example.demo.repository.UserRepository;





@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/user")
public class UserController {

	  @Autowired
	  UserRepository userRepository;
	  
	  @GetMapping("/getId/{matriculeP}")
		public ResponseEntity<Long> getIdPersonnelByMatriculeP(@PathVariable(value = "matriculeP") String matriculeP) throws Exception {
		  Optional<Personnel> personnel = userRepository.findByMatriculeP(matriculeP);
		    //if (personnel == null) {\
		     //   throw new Exception("Personnel not found for this matriculeP :: " + matriculeP);
		  //  }
		    Long idPersonnel = personnel.get().getIdP();
		    return ResponseEntity.ok().body(idPersonnel);
		}

	    @GetMapping("/get/{mat}")
	    public  Optional<Personnel> get(@PathVariable String mat){
	  	return this.userRepository.findByMatriculeP(mat);
	    }

	    
	    
	    
	    @GetMapping("/getbyrole/{role}")
	    public List<Personnel> get(@PathVariable Integer role){
	  	return this.userRepository.findAllPersonnelsByRole(role);
	    }
		
		@GetMapping("getAll")
		public List<Personnel> getAll(){
		return userRepository.findAll();
		}
		
		
		@PostMapping("add")
		public Personnel ajout(@RequestBody Personnel f) {
			return userRepository.save(f);
		}
		@Transactional
		@DeleteMapping("/delete/{mat}")
		public ResponseEntity<String> delete(@PathVariable String mat) {
			userRepository.deleteByMatriculeP(mat);
			return ResponseEntity.ok("Deleted");
		}
		
		@Transactional
		@DeleteMapping("/deleteid/{id}")
		public ResponseEntity<String> deleteid(@PathVariable Long id) {
			userRepository.deleteByIdP(id);
			return ResponseEntity.ok("Deleted");
		}
		
		@PutMapping("/update")
		public Personnel update(@RequestBody Personnel u) {

		    Optional<Personnel> p = userRepository.findByIdP(u.getIdP());
		    
		    if (p.isPresent()) {
		        Personnel personnelToUpdate = p.get();
		        
		        if (u.getMatriculeP() != null) {
		            personnelToUpdate.setMatriculeP(u.getMatriculeP());
		        }
		        if (u.getEmail() != null) {
		            personnelToUpdate.setEmail(u.getEmail());
		        }
		        if (u.getNom() != null) {
		            personnelToUpdate.setNom(u.getNom());
		        }
		        if (u.getPrenom() != null) {
		            personnelToUpdate.setPrenom(u.getPrenom());
		        }
		        if (u.getRole() != null) {
		            personnelToUpdate.setRole(u.getRole());
		        }
		        if (u.getTel() != 0) {
		            personnelToUpdate.setTel(u.getTel());
		        }
		        if (u.getPoste() != null) {
		            personnelToUpdate.setPoste(u.getPoste());
		        }
		        if (u.getPassword() != null) {
		            personnelToUpdate.setPassword(u.getPassword());
		        }
		        if (u.getAdresse() != null) {
		            personnelToUpdate.setAdresse(u.getAdresse());
		        }
		        if (u.getDate_embauche() != null) {
		            personnelToUpdate.setDate_embauche(u.getDate_embauche());
		        }
		        if (u.getDate_naissance() != null) {
		            personnelToUpdate.setDate_naissance(u.getDate_naissance());
		        }
		        if (u.getEtat_civile() != null) {
		            personnelToUpdate.setEtat_civile(u.getEtat_civile());
		        }
		        if (u.getNombre_enfants() != 0) {
		            personnelToUpdate.setNombre_enfants(u.getNombre_enfants());
		        }
		        if (u.getNotes() != null) {
		            personnelToUpdate.setNotes(u.getNotes());
		        }
		        if (u.getService() != null) {
		            personnelToUpdate.setService(u.getService());
		        }
		       
		        if (u.getSexe() != null) {
		            personnelToUpdate.setSexe(u.getSexe());
		        }
		        
		        Personnel updatedPersonnel = userRepository.save(personnelToUpdate);
		        return updatedPersonnel;
		    } else {
		        throw new EntityNotFoundException("Impossible de trouver le personnel à mettre à jour avec l'ID " + u.getIdP());
		    }
		}

}
