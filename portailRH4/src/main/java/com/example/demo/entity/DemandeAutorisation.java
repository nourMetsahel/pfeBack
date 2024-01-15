package com.example.demo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("autorisation")
public class DemandeAutorisation extends Demande {
	
	private String typeA ;
	
	public DemandeAutorisation() {
		// TODO Auto-generated constructor stub
	}

	public DemandeAutorisation(String typeA) {
		super();
		this.typeA = typeA;
	}

	public String getTypeA() {
		return typeA;
	}

	public void setTypeA(String typeA) {
		this.typeA = typeA;
	}
	
	
	

}
