package com.worldvista.Gestion.Pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class historyConnexion {
	private LocalDate dateConnexion;
	private LocalTime heureConnexion;
	private Long idUser;
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
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public historyConnexion(LocalDate dateConnexion, LocalTime heureConnexion, Long idUser) {
		super();
		this.dateConnexion = dateConnexion;
		this.heureConnexion = heureConnexion;
		this.idUser = idUser;
	}
	
	
}
