package com.worldvistaGestion.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldvista.Gestion.Pojo.historyConnexion;
import com.worldvista.Gestion.Pojo.lastConnexion;
import com.worldvistaGestion.Dao.ConnexionRepository;
import com.worldvistaGestion.Entities.Connexion;

@Service
public class serviceConnexion {
	
	@Autowired
	ConnexionRepository connexionRepos ;
	
	public  List<lastConnexion> myLastConnexion(Long idUser) {
		return connexionRepos.getDerniereConnexion(idUser);
	}
	
	public List<Connexion> findByUser(Long idUser) {
    	return 	connexionRepos.connexionByUser(idUser);
	}
	
	public List<historyConnexion> mesHistoriques(Long idUser) {
		return connexionRepos.getMesHistoriquesDeConnexion(idUser);
	}
	
//	public List<Connexion> connexionParMois( Long idUser , LocalDate dateDebut , LocalDate dateFin) {
//		return connexionRepos.filtreConnexionParMois( idUser , dateDebut, dateFin);
//	}
	public Long maDerniereDuree(Long idUser) {
		return connexionRepos.dureeDerniereConnexion(idUser);
	}
	
	//Admin
	public Iterable<Connexion> getAllHistorique(){
		return connexionRepos.findAll();
	};
	
	public List<Connexion> topConnexion(){
		return connexionRepos.getTopConnexion();
	}
}
