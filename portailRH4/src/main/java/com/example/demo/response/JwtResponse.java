package com.example.demo.response;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.entity.Service;

public class JwtResponse {
	 private String token;
	  private String type = "Bearer";
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private Long idP ;
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
	private List<String> role;
	private String sexe;
	private Service service;
	
	public JwtResponse() {
		super();
	}
	
	
	
	
	public JwtResponse(Long idP,String token, String type, String email, String matriculeP, String nom, String prenom, int tel,
			String poste, String password, String adresse, Date date_embauche, Date date_naissance,
			 String etat_civile, int nombre_enfants, String notes, String SEXE, Service service, List<String> role) {
		super();
		this.idP=idP;
		this.token = token;
		this.type = type;
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
		this.sexe = sexe;
		this.service = service;
		this.role = role;
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
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
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
	
	
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
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
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}
	public Long getIdP() {
		return idP;
	}
	public void setIdP(Long idP) {
		this.idP = idP;
	}
	

}
