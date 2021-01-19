package com.worldvista.Gestion.Pojo;

import java.time.LocalDate;

public class transac {
	private Long idTransaction;
	private LocalDate dateTransaction;
	private String typeTransaction;
	private Double mtTransaction;
	private int commission;
	public transac(Long idTransaction, LocalDate dateTransaction, String typeTransaction, Double mtTransaction , int commission) {
		super();
		this.idTransaction = idTransaction;
		this.dateTransaction = dateTransaction;
		this.typeTransaction = typeTransaction;
		this.mtTransaction = mtTransaction;
		this.commission = commission;
	}
	public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}
	public LocalDate getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
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
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	
}
