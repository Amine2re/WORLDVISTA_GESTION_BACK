package com.worldvistaGestion.services.admin;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldvistaGestion.Dao.DepenseRepository;
import com.worldvistaGestion.Entities.Depense;

@Service
public class serviceDepenseAdmin {
	
	@Autowired
	DepenseRepository depRepos;
	
	public void suppimerDepense(Long idDepense) {
		depRepos.deleteById(idDepense);
	};
	
	public void updateDepense(Depense depense) {
		depRepos.save(depense);
	};
	
	public Object totalDepenseMensuelle(String firstDate , String lastDate) {
		return depRepos.getTotalDepenseParMois(LocalDate.parse(firstDate), LocalDate.parse(lastDate));
	}
	
	public Double totalDepenseById(Long idUser) {
		return depRepos.getTotalDepense(idUser);
	}
}
