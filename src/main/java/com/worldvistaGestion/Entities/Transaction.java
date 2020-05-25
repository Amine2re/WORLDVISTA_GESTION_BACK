package com.worldvistaGestion.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction implements Serializable{

	private static final long serialVersionUID = 833929615680663797L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTransaction;
	@Column
	private String typeTransaction;
	private Double mtTransaction;
	private LocalDate dateTransaction;
	private Long idUser;
	private  boolean StatusTransaction;
	
	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public String getTypeTransaction() {
		return typeTransaction;
	}

	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	public Double getMtTransaction() {
		return mtTransaction;
	}

	public void setMtTransaction(Double mtTransaction) {
		this.mtTransaction = mtTransaction;
	}

	public LocalDate getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public boolean isStatusTransaction() {
		return StatusTransaction;
	}

	public void setStatusTransaction(boolean statusTransaction) {
		StatusTransaction = statusTransaction;
	}

	public Transaction(Long idTransaction, String typeTransaction, Double mtTransaction, LocalDate dateTransaction,
			Long idUser, boolean statusTransaction) {
		super();
		this.idTransaction = idTransaction;
		this.typeTransaction = typeTransaction;
		this.mtTransaction = mtTransaction;
		this.dateTransaction = dateTransaction;
		this.idUser = idUser;
		StatusTransaction = statusTransaction;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
