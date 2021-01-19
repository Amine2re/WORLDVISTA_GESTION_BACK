package com.worldvistaGestion.services.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldvista.Gestion.Pojo.fullUser;
import com.worldvistaGestion.Dao.CompteRepository;
import com.worldvistaGestion.Dao.UserRepository;
import com.worldvistaGestion.Entities.Compte;
import com.worldvistaGestion.Entities.User;

@Service
public class serviceUserAdmin {
	
	@Autowired
	UserRepository userRepos;
	
	@Autowired
	CompteRepository comptRepos;
	
	Compte compte ;
	
	public Optional<User> rechercherUser(Long idUser) {
		return userRepos.findById(idUser);
	};
	
	public List<User> getAllUser(){
		return userRepos.findAll();
	};
	
	public Iterable<fullUser> getFullUserInformation(Long idUser) {
		return userRepos.fullUserInfos(idUser);
	}
	
	public boolean ceerUser(User user) {
			
			Optional<User> optionalUser = userRepos.findById(user.getIdUser());
			
	//		VERIFICATION DE L'EXISTANCE DE USER
			
			if(optionalUser.isPresent()) {
				return false;
			}else {
				
	//			SAUVEGARDE DE L'UTILISATEUR
				
				user = optionalUser.get();
				userRepos.save(user);
				
	//			ATTRIBUTION ET SAUVEGARDE DE COMPTE AU NOUVEL UTILISATEUR
				
				compte.setPassword(""+user.getIdUser());
				compte.setSituationCompte(true);
				compte.setStatutCompte(false);
				compte.setTypeCompte("_USER");
				compte.setIdUser(user.getIdUser());
				
				comptRepos.save(compte);
				return true;
			}
		} 
}
