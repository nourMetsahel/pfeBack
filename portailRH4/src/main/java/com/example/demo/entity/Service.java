package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Service {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idService;
	private String nomService;
	
	
	

	@OneToMany(mappedBy="service", fetch=FetchType.LAZY)
	private Collection<Personnel> personnels;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idChef")
    private Personnel personnel;
	
	public Service() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdService() {
		return idService;
	}

	public void setIdService(Long idService) {
		this.idService = idService;
	}

	

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	

	

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public Service(Long idService, String nomService, Personnel personnel) {
		super();
		this.idService = idService;
		this.nomService = nomService;
		
		
		this.personnel = personnel;
	}

	
}