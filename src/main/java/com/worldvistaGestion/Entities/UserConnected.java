package com.worldvistaGestion.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserConnected {
	@Id
	private Long idUser;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public UserConnected(Long idUser) {
		super();
		this.idUser = idUser;
	}

	public UserConnected() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
