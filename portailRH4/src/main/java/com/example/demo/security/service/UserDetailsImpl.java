package com.example.demo.security.service;



import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Personnel;
import com.example.demo.entity.Role;
import com.example.demo.entity.Service;



public class UserDetailsImpl implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String sexe;
	private Service service ;
	
	private Collection<? extends GrantedAuthority> authorities;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nom;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static UserDetailsImpl build(Personnel user) {
	    Role role = user.getRole();
	    List<GrantedAuthority> authorities = Collections.singletonList(
	        new SimpleGrantedAuthority(role.getNomRole().name())
	    );
	/*public static UserDetailsImpl build(Personnel user) {
	    List<GrantedAuthority> authorities = user.getRoles().stream()
	        .map(role -> new SimpleGrantedAuthority(role.getNomRole().name()))
	        .collect(Collectors.toList());
*/
    return new UserDetailsImpl(
        user.getIdP(),
        user.getEmail(),
        user.getMatriculeP(),
        user.getNom(),
         user.getPrenom(),
        user.getTel(),
        user.getPoste(),
        user.getPassword(),
        user.getAdresse(),
         user.getDate_embauche(),
        user.getDate_naissance(),
        user.getEtat_civile(),
        user.getNombre_enfants(),
        user.getNotes(),
        user.getSexe(), 
        user.getService(),
        authorities);
  }
	
	
	
	

	public UserDetailsImpl(Long idP, String email, String matriculeP, String nom, String prenom, int tel,
			String poste, String password, String adresse, Date date_embauche, Date date_naissance, String etat_civile,
			int nombre_enfants, String notes, String sexe, Service service, Collection<? extends GrantedAuthority> authorities) {
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
		this.sexe = sexe;
		this.service = service;
		this.authorities = authorities;
	}

	public UserDetailsImpl() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
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


	

}