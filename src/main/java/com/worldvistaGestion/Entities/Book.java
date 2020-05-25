package com.worldvistaGestion.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBook;
	
	@Column
	private String nomBook;
	
	@ManyToOne
	@JoinColumn(name="idAuteur")
	private Auteur auteur ;
	
	

	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public String getNomBook() {
		return nomBook;
	}

	public void setNomBook(String nomBook) {
		this.nomBook = nomBook;
	}

	public String getNomAuteur() {
		return auteur.getNomAuteur();
	}
	
	public Long getIdAuteur() {
		return auteur.getIdAuteur();
	}
	
	
	public Auteur getAuteur() {
		return auteur;
	}


	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	
	
	
}
