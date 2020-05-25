package com.worldvistaGestion.services.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldvistaGestion.Dao.CompteRepository;
import com.worldvistaGestion.Dao.UserRepository;
import com.worldvistaGestion.Entities.Compte;
import com.worldvistaGestion.Entities.User;

@Service
public class serviceCompteAdmin {
	
	@Autowired
	CompteRepository comptRepos;
	
	@Autowired
	UserRepository userRepos;
	
	
	Compte compte = new Compte();
	User user ;
	public Iterable<Compte> getAllCompte() {
		return comptRepos.findAll();
	}
	public void supprimerCompte(Long idCompte) {
		  comptRepos.deleteById(idCompte);
	};
	public boolean activerCompte(Long idCompte) {
		Optional<Compte> optionalCompte = comptRepos.findById(idCompte);
		 if(optionalCompte.isPresent()) {
			 compte.setSituationCompte(true);
			 comptRepos.save(compte);
			 return true;
		 }
		 return false;
	};
	public boolean desactiverCompte(Long idCompte) {
		Optional<Compte> optionalCompte = comptRepos.findById(idCompte);
		 if(optionalCompte.isPresent()) {
			 compte = optionalCompte.get();
			compte.setSituationCompte(false);
			 comptRepos.save(compte);
			 return true;
		 }
		 return false;
	};
}
