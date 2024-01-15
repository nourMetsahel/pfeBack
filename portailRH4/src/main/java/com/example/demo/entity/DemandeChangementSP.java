package com.example.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("changement de SP")

public class DemandeChangementSP extends Demande {
	
	private String typeCH;
	private String modification;
	public String getTypeCH() {
		return typeCH;
	}
	public void setTypeCH(String typeCH) {
		this.typeCH = typeCH;
	}
	public String getModification() {
		return modification;
	}
	public void setModification(String modification) {
		this.modification = modification;
	}
	public DemandeChangementSP(String typeCH, String modification) {
		super();
		this.typeCH = typeCH;
		this.modification = modification;
	}
	
	public DemandeChangementSP() {
		// TODO Auto-generated constructor stub
	}
	
 

}
