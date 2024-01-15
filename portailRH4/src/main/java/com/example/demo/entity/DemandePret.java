package com.example.demo.entity;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("pret")
public class DemandePret extends Demande{
	
private String typeP;

private float montant;

public DemandePret() {
	// TODO Auto-generated constructor stub
}

public DemandePret(String typeP, float montant) {
	super();
	this.typeP = typeP;
	this.montant = montant;
}

public String getTypeP() {
	return typeP;
}

public void setTypeP(String typeP) {
	this.typeP = typeP;
}

public float getMontant() {
	return montant;
}

public void setMontant(float montant) {
	this.montant = montant;
}



}
