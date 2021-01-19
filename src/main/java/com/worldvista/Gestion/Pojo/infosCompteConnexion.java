package com.worldvista.Gestion.Pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class infosCompteConnexion {
	private LocalDate dateConnexion;
	private LocalTime heureConnexion;
	private Long dureeConnexion;
	
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
	public infosCompteConnexion(LocalDate dateConnexion, LocalTime heureConnexion , Long dureeConnexion) {
		super();
		this.dateConnexion = dateConnexion;
		this.heureConnexion = heureConnexion;
		this.dureeConnexion = dureeConnexion;
	}
	public Long getDureeConnexion() {
		return dureeConnexion;
	}
	public void setDureeConnexion(Long dureeConnexion) {
		this.dureeConnexion = dureeConnexion;
	}
	
	
}
