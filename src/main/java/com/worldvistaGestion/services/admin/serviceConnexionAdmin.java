package com.worldvistaGestion.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldvistaGestion.Dao.ConnexionRepository;
import com.worldvistaGestion.Entities.Connexion;

@Service
public class serviceConnexionAdmin {

	@Autowired 
	ConnexionRepository connexRepos;
	
	public Iterable<Connexion> getAllConnexions(Long idUser){
		return connexRepos.getAllHistory(idUser);
	}
}
