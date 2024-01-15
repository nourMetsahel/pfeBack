package com.example.demo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mutation")
public class DemandeMutation extends Demande {
	
	private String typeM ;
	private String posteS ;
	
	public DemandeMutation() {
		// TODO Auto-generated constructor stub
	}
	
	public DemandeMutation(String typeM, String posteS) {
		super();
		this.typeM = typeM;
		this.posteS = posteS;
	}
	public String getTypeM() {
		return typeM;
	}
	public void setTypeM(String typeM) {
		this.typeM = typeM;
	}
	public String getPosteS() {
		return posteS;
	}
	public void setPosteS(String posteS) {
		this.posteS = posteS;
	}
	

}
