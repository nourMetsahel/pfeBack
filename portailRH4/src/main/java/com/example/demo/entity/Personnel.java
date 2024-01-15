package com.example.demo.entity;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



@Entity
@Table(name = "Personnel", uniqueConstraints = {
        @UniqueConstraint(columnNames = "matriculeP")
})
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Personnel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idP;
	private String email ;
	private String matriculeP ;
	private String nom ;
	private String prenom ;
	private int tel ;
	private String poste ;
	private String password ;
	private String adresse;
	@Temporal(TemporalType.DATE)
	// @JsonFormat(value="dd\mm\yyyy")
	private Date date_embauche;
	@Temporal(TemporalType.DATE)
	// @JsonFormat(value="dd\mm\yyyy")
	private Date date_naissance;

	private String etat_civile;
	private int nombre_enfants;
	private String notes;
	//@ManyToMany(fetch = FetchType.LAZY)
	//@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	//private Set<Role> roles = new HashSet<>();
	private String sexe;
	@ManyToOne
	@JoinColumn(name="role")
	private Role role;
	
	
	@OneToMany(mappedBy="personnel", fetch=FetchType.LAZY)
	private Collection<Demande> demandes;
	
	@ManyToOne
	@JoinColumn(name="idService")
	//@JsonSerialize(using = ServiceSerializer.class)
	private Service service;
	
//	@OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ChefDe")
//     private Service chefDe;
//	 
	
	
//	
//	public Service getChefDe() {
//		return chefDe;
//	}
//	public void setChefDe(Service chefDE) {
//		this.chefDe = chefDE;
//	}
	public Personnel() {
		super();
	}
	public Long getIdP() {
		return idP;
	}
	public void setIdP(Long idP) {
		this.idP = idP;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatriculeP() {
		return matriculeP;
	}
	public void setMatriculeP(String matriculeP) {
		this.matriculeP = matriculeP;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getTel() {
		return tel;
	}
	
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	*/
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDate_embauche() {
		return date_embauche;
	}
	public void setDate_embauche(Date date_embauche) {
		this.date_embauche = date_embauche;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	
	public String getEtat_civile() {
		return etat_civile;
	}
	public void setEtat_civile(String etat_civile) {
		this.etat_civile = etat_civile;
	}
	public int getNombre_enfants() {
		return nombre_enfants;
	}
	public void setNombre_enfants(int nombre_enfants) {
		this.nombre_enfants = nombre_enfants;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	/*public Personnel(Long idP, String email, String matriculeP, String nom, String prenom, int tel, String poste,
			String password, String adresse, Date date_embauche, Date date_naissance, 
			String etat_civile, int nombre_enfants, String notes, Set<Role> roles) {
		super();
		this.idP = idP;
		this.email = email;
		this.matriculeP = matriculeP;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.poste = poste;
		this.password = password;
		this.adresse = adresse;
		this.date_embauche = date_embauche;
		this.date_naissance = date_naissance;
		
		this.etat_civile = etat_civile;
		this.nombre_enfants = nombre_enfants;
		this.notes = notes;
		this.roles = roles;
	}
	
	public Personnel(String email, String matriculeP, String nom, String prenom, int tel, String poste, String password,
			String adresse, Date date_embauche, Date date_naissance, String etat_civile,
			int nombre_enfants, String notes, Set<Role> roles) {
		super();
		this.email = email;
		this.matriculeP = matriculeP;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.poste = poste;
		this.password = password;
		this.adresse = adresse;
		this.date_embauche = date_embauche;
		this.date_naissance = date_naissance;
		this.etat_civile = etat_civile;
		this.nombre_enfants = nombre_enfants;
		this.notes = notes;
		this.roles = roles;
	}*/
	public Personnel( String email, String matriculeP, String nom, String prenom, int tel, String poste, String password,
			String adresse, Date date_embauche, Date date_naissance, String etat_civile,
			int nombre_enfants, String notes, Service service,String sexe) {
		super();
		
		this.email = email;
		this.matriculeP = matriculeP;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.poste = poste;
		this.password = password;
		this.adresse = adresse;
		this.date_embauche = date_embauche;
		this.date_naissance = date_naissance;
		this.etat_civile = etat_civile;
		this.nombre_enfants = nombre_enfants;
		this.notes = notes;
		this.service = service;
		this.sexe=sexe;
		
	}
/*
	public Personnel(String email, String nom, String prenom, int tel, String poste, String password, String adresse,
			Date date_embauche, Date date_naissance, String etat_civile, int nombre_enfants, String notes,
			Set<Role> roles) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.poste = poste;
		this.password = password;
		this.adresse = adresse;
		this.date_embauche = date_embauche;
		this.date_naissance = date_naissance;
		this.etat_civile = etat_civile;
		this.nombre_enfants = nombre_enfants;
		this.notes = notes;
		this.roles = roles;
	}
*/
	public Personnel(String email, String nom, String prenom, int tel, String poste, String password, String adresse,
			Date date_embauche, Date date_naissance, String etat_civile, int nombre_enfants, String notes, Service service,String sexe) {
		super();
		
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.poste = poste;
		this.password = password;
		this.adresse = adresse;
		this.date_embauche = date_embauche;
		this.date_naissance = date_naissance;
		this.etat_civile = etat_civile;
		this.nombre_enfants = nombre_enfants;
		this.notes = notes;
		this.service = service;
		this.sexe=sexe;
		
		
	}
public Personnel(String email, String matriculeP, String nom, String prenom, int tel, String poste, String password,
		String adresse, Date date_embauche, Date date_naissance, String etat_civile, int nombre_enfants, String notes,
		Role role, Collection<Demande> demandes, Service service, String sexe) {
	super();
	this.email = email;
	this.matriculeP = matriculeP;
	this.nom = nom;
	this.prenom = prenom;
	this.tel = tel;
	this.poste = poste;
	this.password = password;
	this.adresse = adresse;
	this.date_embauche = date_embauche;
	this.date_naissance = date_naissance;
	this.etat_civile = etat_civile;
	this.nombre_enfants = nombre_enfants;
	this.notes = notes;
	this.role = role;
	this.demandes = demandes;
	this.service = service;
	this.sexe=sexe;
	
	
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}
	
	
	
	 
	}