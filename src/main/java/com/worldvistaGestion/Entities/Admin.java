package com.worldvistaGestion.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin implements Serializable{

	private static final long serialVersionUID = -1709135894419982024L;
	
	@Id
	private Long idAdmin ;
	@Column
	private String password ;
	public Long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(Long idAdmin, String password) {
		super();
		this.idAdmin = idAdmin;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
