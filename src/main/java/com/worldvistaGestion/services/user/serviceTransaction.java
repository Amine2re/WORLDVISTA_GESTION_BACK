package com.worldvistaGestion.services.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldvistaGestion.Dao.TransactionRepository;
import com.worldvistaGestion.Entities.Transaction;

@Service
public class serviceTransaction {

	
	@Autowired
	TransactionRepository transacRepos;
	
	public void faireDepot(Transaction transaction) {
		transacRepos.save(transaction);
	};
	
	public void faireRetrait(Transaction transaction) {
		transacRepos.save(transaction);
	};
	
	public List<Transaction> rechercheTransaction(String typeTransaction) {
		return transacRepos.rechercheTransactionByType(typeTransaction.toUpperCase());
	};
	
	public Double getTransactionAvancement() {
		return transacRepos.getTransactionAvancement();
	}
	
	public Iterable<Transaction> transactionsDuJour(LocalDate today) {
		return transacRepos.getAllTransactionDuJour(today);
	}
	
	public Iterable<Transaction> topTransaction(Long idUser) {
		return transacRepos.findByIdUser(idUser);
	}
	
}
