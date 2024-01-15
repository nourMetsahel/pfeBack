package com.example.demo.entity;


import java.util.Date;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("conge")
public class DemandeConge extends Demande{
	
	private String typeC;
	
	@Temporal(TemporalType.DATE)
	// @JsonFormat(value="dd\mm\yyyy")
	private Date dateDe;
	
	@Temporal(TemporalType.DATE)
	// @JsonFormat(value="dd\mm\yyyy")
	private Date dateF;
	
	private int nombreJ;

	public String getTypeC() {
		return typeC;
	}

	public void setTypeC(String typeC) {
		this.typeC = typeC;
	}

	public Date getDateDe() {
		return dateDe;
	}

	public void setDateDe(Date dateDe) {
		this.dateDe = dateDe;
	}

	public Date getDateF() {
		return dateF;
	}

	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

	public int getNombreJ() {
		return nombreJ;
	}

	public void setNombreJ(int nombreJ) {
		this.nombreJ = nombreJ;
	}
 
	
	public DemandeConge() {
		// TODO Auto-generated constructor stub
	}

	public DemandeConge(String typeC, Date dateDe, Date dateF, int nombreJ) {
		super();
		this.typeC = typeC;
		this.dateDe = dateDe;
		this.dateF = dateF;
		this.nombreJ = nombreJ;
	}
	
	
	
}
