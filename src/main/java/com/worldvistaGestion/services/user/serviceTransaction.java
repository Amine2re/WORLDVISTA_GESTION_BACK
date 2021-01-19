package com.worldvistaGestion.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.worldvista.Gestion.Pojo.transac;
import com.worldvistaGestion.Dao.TransactionRepository;
import com.worldvistaGestion.Entities.Transaction;
import com.worldvistaGestion.services.sup.serviceHoraire;

@Service
public class serviceTransaction {
 
	
	@Autowired
	TransactionRepository transacRepos;
	
	@Autowired
	serviceHoraire _horaire;
	
	public void newTransaction(Transaction transaction) {
		if(transaction.getDateTransaction()==null)
		transaction.setDateTransaction(_horaire.today());
		transacRepos.save(transaction);
	};
	
	public Integer getNombreTransactionById(Long idUser) {
		return transacRepos.getNbTransactionByUser(idUser);
	}
	
	public List<Transaction> rechercheTransaction(String typeTransaction) {
		return transacRepos.rechercheTransactionByType(typeTransaction.toUpperCase());
	};
	
	public Double getTransactionAvancement() {
		return transacRepos.getTransactionAvancement();
	}
	
	public Iterable<Transaction> transactionsDuJour() {
		return transacRepos.getAllTransactionDuJour(_horaire.today());
	}
	
	public Iterable<transac> transactionsDuJourById(Long idUser) {
		return transacRepos.getAllTransactionDuJourById(_horaire.today(),idUser);
	}
	
	public List<Transaction> transactionsById(Long idUser,int page) {
		return transacRepos.getAllTransactionById(idUser,PageRequest.of(page,10));
	}
	
	public Iterable<Transaction> topTransaction(Long idUser) {
		return transacRepos.getTopTransactionById(idUser, PageRequest.of(0, 5));
	}

	public int[] getTotalTransaction(Long idUser) {
		int nbPage = transacRepos.getTotalPageTransac(idUser,PageRequest.of(0, 10)).getTotalPages();
		int[] tabNbPage = new int[nbPage];
		for(int i = 0 ; i < tabNbPage.length ; i++) {
			tabNbPage[i] = i ;}
		return tabNbPage;
	}
	
	public double getStatusCommissionByUser(Long idUser) {
//		System.out.println(transacRepos.getStatusCommissionByUser(idUser));
		return transacRepos.getStatusCommissionByUser(idUser);
	}
	
	public int getStatusCommission() {
//		System.out.println(transacRepos.getStatusCommission());
		return transacRepos.getStatusCommission();
	}
	
}
