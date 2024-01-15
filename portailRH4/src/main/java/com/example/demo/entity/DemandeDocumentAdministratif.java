package com.example.demo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("document administratif")
public class DemandeDocumentAdministratif extends Demande {
	
	private String typeDA;

	public String getTypeDA() {
		return typeDA;
	}

	public void setTypeDA(String typeDA) {
		this.typeDA = typeDA;
	}

	public DemandeDocumentAdministratif(String typeDA) {
		super();
		this.typeDA = typeDA;
	}
	
	public DemandeDocumentAdministratif() {
		// TODO Auto-generated constructor stub
	}

}
