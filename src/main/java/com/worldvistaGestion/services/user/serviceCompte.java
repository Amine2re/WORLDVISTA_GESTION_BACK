package com.worldvistaGestion.services.user;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldvistaGestion.Dao.CompteRepository;
import com.worldvistaGestion.Entities.Compte;

@Service
public class serviceCompte {
	
	@Autowired
	CompteRepository comptRepos;
	
	
	Optional<Compte> optCompt ;
	Compte compte ;

	@PostConstruct
	public void initializer() {
		 compte = new Compte();
	}
	
	public boolean updatePassword(Long idUser , String password) {
		optCompt = comptRepos.findByIdUser(idUser);
		if(optCompt.isPresent()) {
				optCompt.get().setPassword(password);
				comptRepos.save(optCompt.get());
				return true;
		}
		return false;
	};
	
	public Object getCompteInformations(Long idUser) {
		return comptRepos.findByIdUser(idUser);
	}

}
