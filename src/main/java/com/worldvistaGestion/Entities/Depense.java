package com.worldvistaGestion.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Depense implements Serializable{

	private static final long serialVersionUID = 588379703779986288L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDepense;
	@Column
	private Double MtDepense;
	private String Description; 
	private LocalDate dateDepense;
	private Long idUser;
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdDepense() {
		return idDepense;
	}
	public void setIdDepense(Long idDepense) {
		this.idDepense = idDepense;
	}
	public Double getMtDepense() {
		return MtDepense;
	}
	public void setMtDepense(Double mtDepense) {
		MtDepense = mtDepense;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public LocalDate getDateDepense() {
		return dateDepense;
	}
	public void setDateDepense(LocalDate dateDepense) {
		this.dateDepense = dateDepense;
	}
//	public Long getIdUser() {
//		return idUser;
//	}
//	public void setIdUser(Long idUser) {
//		this.idUser = idUser;
//	}
	public Depense(Long idDepense, Double mtDepense, String description, LocalDate dateDepense, Long idUser) {
		super();
		this.idDepense = idDepense;
		MtDepense = mtDepense;
		Description = description;
		this.dateDepense = dateDepense;
//		this.idUser = idUser;
	}
	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
