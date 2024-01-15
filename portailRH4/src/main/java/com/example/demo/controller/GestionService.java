package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.UserRepository;



@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/service")
public class GestionService {
	
	@Autowired
	private ServiceRepository dao;
	
	@Autowired
	private UserRepository udao;
	
	
	@PostMapping("add")
	public Service ajout(@RequestBody Service f) {
		return dao.save(f);
	}
	/*@Transactional
	@DeleteMapping("/delete1/{mat}")
	public ResponseEntity<String> delete(@PathVariable String mat) {
		dao.deleteByMatriculChef(mat);
		return ResponseEntity.ok("Deleted");
	}*/
	@Transactional
	@DeleteMapping("/delete3/{id}")
	public ResponseEntity<String> deleteid(@PathVariable Personnel id) {
		dao.deleteByPersonnel(id);
		return ResponseEntity.ok("Deleted");
	}
	
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteidS(@PathVariable Long id) {
		dao.deleteByIdService(id);
		return ResponseEntity.ok("Deleted");
	}
	
	/*@GetMapping("/get2/{mat}")
	public Optional<Service> get(@PathVariable String mat) {
		 return dao.findByMatriculChef(mat);
		
	}*/
	@GetMapping("/get1/{id}")
	public Optional<Service> getid(@PathVariable Personnel id) {
		 return dao.findByPersonnel(id);
		
	}
	@GetMapping("/get/{id}")
	public Optional<Service> getid(@PathVariable Long id) {
		 return dao.findByIdService(id);
		
	}
	
	@GetMapping("getAll")
	public List<Service> getAll(){
	return dao.findAll();
	}
	
	
//	@PutMapping("/update")
//	public Service update(@RequestBody Service u)  {
//	    Optional<Service> service = dao.findByIdService(u.getIdService());
//	    
//	    if (u.getNomService() != null) {
//	        service.get().setNomService(u.getNomService());
//	    }
//	    if (u.getPersonnel() != null) {
//	        service.get().setPersonnel(u.getPersonnel());
//	    }
//	    
//	    Service AdminUpdated = dao.save(service.get());
//	    return AdminUpdated;
//	}
	@PutMapping("/update")
	public Service update(@RequestBody Service u)  {
	    Optional<Service> service = dao.findByIdService(u.getIdService());
	    
	    if (u.getNomService() != null) {
	        service.get().setNomService(u.getNomService());
	    }
	    if (u.getPersonnel() != null) {
	        Personnel personnel = u.getPersonnel();
	        Optional<Personnel> existingPersonnel = udao.findById(personnel.getIdP());
	        if (existingPersonnel.isPresent()) {
	            service.get().setPersonnel(existingPersonnel.get());
	        } else {
	            Personnel savedPersonnel = udao.save(personnel);
	            service.get().setPersonnel(savedPersonnel);
	        }
	    }
	  
	    Service AdminUpdated = dao.save(service.get());
	    return AdminUpdated;
	}


}
