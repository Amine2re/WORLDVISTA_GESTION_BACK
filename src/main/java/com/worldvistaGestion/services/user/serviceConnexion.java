package com.worldvistaGestion.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.worldvista.Gestion.Pojo.historyConnexion;
import com.worldvistaGestion.Dao.ConnexionRepository;
import com.worldvistaGestion.Dao.userConnectedRepository;
import com.worldvistaGestion.Entities.Connexion;
import com.worldvistaGestion.Entities.UserConnected;

@Service
public class serviceConnexion {
	
	@Autowired
	ConnexionRepository connexionRepos ;
	
	@Autowired
	userConnectedRepository connectedRepos ;
	
	public Object getDateConnexionByIdUser(Long idUser) {
		return connexionRepos.lastDateConnexion(idUser);
	}
	
	public Object getHeureConnexionByIdUser(Long idUser) {
		return connexionRepos.lastHoursConnexion(idUser);
	}
	
	public Integer getDureeConnexionByIdUser(Long idUser) {
		return connexionRepos.lastDureeConnexion(idUser);
	}
	
	public List<UserConnected> getIdConnected() {
		return  (List<UserConnected>) connectedRepos.findAll();
	}
	
	public  Object myLastConnexion(Long idUser) {
		return connexionRepos.getDerniereConnexion(idUser);
	}
	
	public List<Connexion> findByUser(Long idUser) {
    	return 	connexionRepos.connexionByUser(idUser);
	}
	
	public List<historyConnexion> mesHistoriques(Long idUser,int page) {
		return connexionRepos.getMesHistoriquesDeConnexion(idUser,PageRequest.of(page, 10));
	}
	
	
	public List<Object> top5ConnexionByIdUser() {
		return connexionRepos.getTop5ConnexionByIdUser(PageRequest.of(0, 5));
	}
	
	public int[] getTotalPageConnexionById(Long idUser) {
		int listePage = connexionRepos.getTotalPageConnexion(idUser, PageRequest.of(0, 10)).getTotalPages();
		int[] tabPage = new int[listePage];
		for (int i : tabPage) {
			tabPage[i]=i;
		}
		return tabPage;
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
