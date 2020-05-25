package com.worldvistaGestion.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -7090708769175358999L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	@Column
	private String nomUser;
	private String prenomUser; 
	private String adresseUser;
	private String emailUser;
	
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getAdresseUser() {
		return adresseUser;
	}

	public void setAdresseUser(String adresseUser) {
		this.adresseUser = adresseUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public User(Long idUser, String nomUser, String prenomUser, String adresseUser, String emailUser, Compte idCompte) {
		super();
		this.idUser = idUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.adresseUser = adresseUser;
		this.emailUser = emailUser;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
