package com.worldvistaGestion.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Connexion implements Serializable{

	private static final long serialVersionUID = 145523918939001094L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConnexion;	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateConnexion;
	private LocalTime heureConnexion;
	private int nbConnexion;
	private Long idCompte;
	private Long idUser;
	private Long dureeConnexion;
//	@ManyToOne
//	@JoinColumn(name="idUser")
//	private User idUser; x

	public Long getIdConnexion() {
		return idConnexion;
	}
	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public void setIdConnexion(Long idConnexion) {
		this.idConnexion = idConnexion;
	}

	public LocalDate getDateConnexion() {
		return dateConnexion;
	}

	public void setDateConnexion(LocalDate dateConnexion) {
		this.dateConnexion = dateConnexion;
	}

	public LocalTime getHeureConnexion() {
		return heureConnexion;
	}

	public void setHeureConnexion(LocalTime heureConnexion) {
		this.heureConnexion = heureConnexion;
	}

	public int getNbConnexion() {
		return nbConnexion;
	}

	public void setNbConnexion(int nbConnexion) {
		this.nbConnexion = nbConnexion;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Connexion(Long idConnexion, LocalDate dateConnexion, LocalTime heureConnexion, int nbConnexion, Long idUser) {
		super();
		this.idConnexion = idConnexion;
		this.dateConnexion = dateConnexion;
		this.heureConnexion = heureConnexion;
		this.nbConnexion = nbConnexion;
		this.idUser = idUser;
	}

	public Connexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getDureeConnexion() {
		return dureeConnexion;
	}

	public void setDureeConnexion(Long dureeConnexion) {
		this.dureeConnexion = dureeConnexion;
	}

}
