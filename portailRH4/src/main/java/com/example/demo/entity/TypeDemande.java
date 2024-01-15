package com.example.demo.entity;

import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class TypeDemande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long matriculeType;
	
	private String nomType;
	
	//@OneToMany(mappedBy="matriculeD", fetch=FetchType.LAZY)
	//private Collection<Demande> demandes;

	public TypeDemande(Long matriculeType, String nomType) {
		super();
		this.matriculeType = matriculeType;
		this.nomType = nomType;
	}
	
	public TypeDemande() {
		// TODO Auto-generated constructor stub
	}

	public Long getMatriculeType() {
		return matriculeType;
	}

	public void setMatriculeType(Long matriculeType) {
		this.matriculeType = matriculeType;
	}

	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}
	
}
