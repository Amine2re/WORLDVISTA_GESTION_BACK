package com.worldvistaGestion.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.worldvistaGestion.Dao.DepenseRepository;
import com.worldvistaGestion.Entities.Depense;

@Service
@Transactional
public class serviceDepense {
	
	@Autowired
	DepenseRepository depRepos;
	
	public void enregisterDepense(Depense depense) {
		depRepos.save(depense);
	};
	public List<Depense> getJournalDepenseById(Long idUser){
		return depRepos.findByIdUser(idUser);
	};
	
}
