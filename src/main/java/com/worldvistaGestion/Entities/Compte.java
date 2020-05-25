package com.worldvistaGestion.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Compte{

	
	@Id
	private Long idCompte;
	@Column
	private String typeCompte;
	private String password;
	private boolean situationCompte;
	private boolean statutCompte;
	private Long idUser;
	
	
	public Long getIdUser() {
		return idUser;
	}
	public Compte(Long idCompte, String typeCompte, boolean situationCompte, boolean statutCompte) {
		super();
		this.idCompte = idCompte;
		this.typeCompte = typeCompte;
		this.situationCompte = situationCompte;
		this.statutCompte = statutCompte;
	}
	public Compte() {
		super();
//		 TODO Auto-generated constructor stub
	}
	public Long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	public boolean isSituationCompte() {
		return situationCompte;
	}
	public void setSituationCompte(boolean situationCompte) {
		this.situationCompte = situationCompte;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	public void setIdUser(Long idUser) {
		this.idUser  = idUser;
	}
	
//	public Long getIdUser() {
//		return user.getIdUser();
//	}
	
	public boolean getStatutCompte() {
		return statutCompte;
	}
	public void setStatutCompte(boolean statutCompte) {
		this.statutCompte = statutCompte;
	}
	
	
}
	