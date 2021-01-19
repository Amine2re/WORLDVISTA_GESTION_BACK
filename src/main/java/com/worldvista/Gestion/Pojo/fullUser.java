package com.worldvista.Gestion.Pojo;

public class fullUser {
	private Long idUser;
	private String nomUser;
	private String PrenomUser ;
	private String emailUser ;
	private String password ;
	private boolean statutCompte ;
	private boolean situationCompte;
	
	
	
	public fullUser(Long idUser, String nomUser, String prenomUser, String emailUser, String password,
			boolean statutCompte, boolean situationCompte) {
		super();
		this.idUser = idUser;
		this.nomUser = nomUser;
		PrenomUser = prenomUser;
		this.emailUser = emailUser;
		this.password = password;
		this.statutCompte = statutCompte;
		this.situationCompte = situationCompte;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getPrenomUser() {
		return PrenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		PrenomUser = prenomUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatutCompte() {
		return statutCompte;
	}
	public void setStatusCompte(boolean statusCompte) {
		this.statutCompte = statusCompte;
	}
	public boolean isSituationCompte() {
		return situationCompte;
	}
	public void setSituationCompte(boolean situationCompte) {
		this.situationCompte = situationCompte;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	
	}
