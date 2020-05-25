package com.worldvistaGestion.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Auteur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAuteur;
	
	@Column
	private String nomAuteur;
	
	@Column
	private String adresseAuteur;
	
	@OneToMany
	private Set<Book> bookListe = new HashSet<>();
	
	public Long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Long idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public String getAdresseAuteur() {
		return adresseAuteur;
	}

	public void setAdresseAuteur(String adresseAuteur) {
		this.adresseAuteur = adresseAuteur;
	}

	public Set<Book> getBookListe() {
		return bookListe;
	}

	public void setBookListe(Set<Book> bookListe) {
		this.bookListe = bookListe;
	}

	

	

}
