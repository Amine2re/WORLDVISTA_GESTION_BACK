package com.worldvistaGestion.services.user;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldvistaGestion.Dao.CompteRepository;
import com.worldvistaGestion.Dao.ConnexionRepository;
import com.worldvistaGestion.Dao.UserRepository;
import com.worldvistaGestion.Dao.userConnectedRepository;
import com.worldvistaGestion.Entities.Compte;
import com.worldvistaGestion.Entities.Connexion;
import com.worldvistaGestion.Entities.User;
import com.worldvistaGestion.Entities.UserConnected;
import com.worldvistaGestion.services.sup.serviceHoraire;

@Service
public class serviceUser {
	
	@Autowired
	UserRepository userRepos;
	
	@Autowired
	CompteRepository comptRepos;
	
	@Autowired
	serviceHoraire _serviceHoraire;
	
	@Autowired
	ConnexionRepository connexRepos;
	
	@Autowired
	userConnectedRepository usrConnectedRepos;
	
	
	Optional<User> userOpt;
	Optional<Compte> compteOpt;
	Optional<Connexion> connexOpt;
	User usr;
	Compte compte;
	Connexion connexion ;
	String password;
	Long actualDuree;

	
	
	@PostConstruct
	public void initialize() {
		usr =  new User();
		compte = new Compte();
		connexion = new Connexion();
	}
	
	public boolean fixDureeConnexion(Long idUser){
		userOpt = userRepos.findById(idUser);
		if(userOpt.isPresent()) {

			List<Connexion> listConnexOpt = connexRepos.connexionByUser(idUser);
			connexion = listConnexOpt.get(listConnexOpt.size()-1);
			
			if(connexion!=null) {
				
			  actualDuree = ChronoUnit.MINUTES.between(connexion.getHeureConnexion(), _serviceHoraire.heureActuelle());
			  connexion.setDureeConnexion(actualDuree);

			  connexRepos.save(connexion);
			  
			  return true;
		  }
		}
		return false;
	}
	
	public Object getUserInformations(Long idUser) {
		return userRepos.findById(idUser);
	}
	public boolean connecter(Long idUser, String password) {
		userOpt =  userRepos.findById(idUser);
		if(userOpt.isPresent()) {
			usr = userOpt.get();
			compteOpt = comptRepos.findByIdUser(idUser);
			if(compteOpt.isPresent()) {
				compte = compteOpt.get();
				if(compte.getPassword().contentEquals(password)) {
					
					connexion = new Connexion();
					
					connexion.setIdCompte(compte.getIdCompte());
					connexion.setDateConnexion(_serviceHoraire.today());
					connexion.setHeureConnexion(_serviceHoraire.heureActuelle());
					connexion.setIdUser(idUser);
					connexion.setNbConnexion(1);
					
					connexRepos.save(connexion);
					
					usrConnectedRepos.deleteAll();
					usrConnectedRepos.save(new UserConnected(idUser));
					
					return true;
				}
			}
		}
		return false;
	};
	
	public boolean deconnecter(Long idUser) {	
		Optional<Compte> optionalUser = comptRepos.findByIdUser(idUser);
		if(optionalUser.isPresent()) {
			compte = optionalUser.get();
			compte.setStatutCompte(false);
			comptRepos.save(compte);
			connexion  = connexRepos.connexionByUserAndIdCompte(idUser, compte.getIdCompte());
			if(connexion!=null) {
				
				Long differenceByMinute = ChronoUnit.MINUTES.between(connexion.getHeureConnexion(),_serviceHoraire.heureActuelle());
					
				connexion.setDureeConnexion(differenceByMinute);
				connexRepos.save(connexion);
				
				return true ;
			}
		}
		return false;
	};
	public User updateMonProfil(User user) {
		return userRepos.save(user);
	}


	
	
	
}
