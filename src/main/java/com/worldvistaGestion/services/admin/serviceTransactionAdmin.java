package com.worldvistaGestion.services.admin;

import java.time.LocalDate;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldvistaGestion.Dao.TransactionRepository;
import com.worldvistaGestion.Entities.Transaction;

@Service
public class serviceTransactionAdmin {
	
	@Autowired
	TransactionRepository transacRepos;
	
	Transaction transaction;
	Optional<Transaction> optTransac;
	
	@PostConstruct
	public void initialize() {
		transaction = new Transaction();
	}
	
	
	public void suppimerTransaction(Long idTransaction) {
		transacRepos.deleteById(idTransaction);
	};
	
	public boolean updateTransaction(Transaction transaction) {
		optTransac = transacRepos.findById(transaction.getIdTransaction());
		if(optTransac.isPresent()) {
			this.transaction = optTransac.get();
			this.transaction.setDateTransaction(transaction.getDateTransaction().toString().length()>0 ? transaction.getDateTransaction() : this.transaction.getDateTransaction());
			this.transaction.setMtTransaction(transaction.getMtTransaction().toString().length()>0 ? transaction.getMtTransaction() : this.transaction.getMtTransaction());
			this.transaction.setTypeTransaction(transaction.getTypeTransaction().toString().length()>0 ? transaction.getTypeTransaction() : this.transaction.getTypeTransaction());
			transacRepos.save(this.transaction);
			return true;
		}
		return false;
	};
	
	
	public Iterable<Transaction> transactionsDuJour(LocalDate today) {
		return transacRepos.getAllTransactionDuJour(today);
	}
	public Double getEvolutionTransactions() {
		return transacRepos.getTransactionAvancement();
	}
	
	public Iterable<Transaction> getTopTransaction(){
		return transacRepos.topTransaction();
	}
	
	public Iterable<Transaction> getAllTransactionByOrder() {
		return transacRepos.getTransactionByOrderDate();
	}
	
	public Iterable<Transaction> getTopTransactionById(Long idUser){
		return transacRepos.findByIdUser(idUser);
	}
	
	public Iterable<Transaction> searchTransactionByType(String typeTransaction){
		return transacRepos.rechercheTransactionByType("%"+typeTransaction+"%");
	}
	
	public Object getMtTranctionMensuelle(String firstDate , String lastDate) {
		return transacRepos.getMtTransactionMensuel(LocalDate.parse(firstDate), LocalDate.parse(lastDate));
	}
}
