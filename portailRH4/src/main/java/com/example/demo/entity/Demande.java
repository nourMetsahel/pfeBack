package com.example.demo.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeD",discriminatorType = DiscriminatorType.STRING)
@AttributeOverride(name = "typeD", column = @Column(name = "typeD", insertable = false, updatable = false))
public abstract class Demande  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idD ; 
	@Temporal(TemporalType.TIMESTAMP)
	// @JsonFormat(value="dd\mm\yyyy")
	private Date timedate;
	private String raison;
	private String matriculeP ; 
	private String statut;
	private String rep;
	private String gere;
	
	
	
	 
	  protected String typeD;
	    
	    public String getTypeD() {
	        return this.typeD;
	    }

	public String generateId() {
	    return UUID.randomUUID().toString();
	}
	
	//@ManyToOne
	//@JoinColumn(name="typeDem")
	//private TypeDemande typeDemande;
	
	@ManyToOne
	@JoinColumn(name="idPers")
	private Personnel personnel; 
	
	
	public Long getIdD() {
		return idD;
	}



	public void setIdD(Long idD) {
		this.idD = idD;
	}



	public void setTypeD(String typeD) {
		this.typeD = typeD;
	}



	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	
	public Date getTimedate() {
		return timedate;
	}
	public void setTimedate(Date timedate) {
		this.timedate = timedate;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public Demande() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Demande(Long idD, Date timedate, String raison, String matriculeP, String typeD,
			Personnel personnel, String statut, String rep,String gere) {
		super();
		this.idD = idD;
		this.timedate = timedate;
		this.raison = raison;
		this.matriculeP = matriculeP;
		this.typeD = typeD;
		this.personnel = personnel;
		this.rep = rep;
		this.gere = gere;
	}



	public String getMatriculeP() {
		return matriculeP;
	}
	public void setMatriculeP(String matriculeP) {
		this.matriculeP = matriculeP;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	public String getGere() {
		return gere;
	}

	public void setGere(String gere) {
		this.gere = gere;
	}

	
	
	

}
