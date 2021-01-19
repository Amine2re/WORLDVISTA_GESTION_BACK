package com.worldvistaGestion.services.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.worldvistaGestion.Dao.DepenseRepository;
import com.worldvistaGestion.Entities.Depense;
import com.worldvistaGestion.services.sup.serviceHoraire;

@Service
@Transactional
public class serviceDepense {
	
	@Autowired
	DepenseRepository depRepos;
	
	@Autowired
	serviceHoraire _serviceHoraire;
	
	public List<Object> nbDepense(Long idUser) {
		return depRepos.nbDepenseById(idUser);
	}
	
	public void enregisterDepense(Depense depense) {
		depense.setDateDepense(_serviceHoraire.today());
		depRepos.save(depense);
	};
	public List<Depense> getJournalDepenseById(Long idUser,int page){
		return depRepos.findByIdUserPage(idUser, PageRequest.of(page,5));
	};
	
	public List<Depense> getDepenseByIdUser(Long idUser) {
		return depRepos.findDepenseByIdUser(idUser);
	}
	
	public double totalDepenseById(Long idUser) {
		return depRepos.getTotalDepense(idUser);
	}

	public  int[] getTotalPage(Long idUser , int page) {
		// TODO Auto-generated method stub
		int nbPage = depRepos.totalPage(idUser, PageRequest.of(page,5)).getTotalPages();
		int [] tabPage = new int [nbPage];
		
		for(int i = 1 ; i < tabPage.length ; i++) {
			tabPage[i] = i ;
		}		
		return tabPage;
	}
	
//	public static void main(String args[]) {
//		System.out.println(new serviceDepense().getDepenseByIdUser((long) 2));
//	}
	
}
