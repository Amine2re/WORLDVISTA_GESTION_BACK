package com.worldvista.Gestion.Pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class lastConnexion {
	
	private LocalDate dateConnexion;
	private LocalTime heureConnexion;
	
	public lastConnexion(LocalDate dateConnexion, LocalTime heureConnexion) {
		super();
		this.dateConnexion = dateConnexion;
		this.heureConnexion = heureConnexion;
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
	

}
