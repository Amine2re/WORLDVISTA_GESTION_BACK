package com.worldvistaGestion.RestAPI;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.worldvista.Gestion.Pojo.historyConnexion;
import com.worldvista.Gestion.Pojo.lastConnexion;
import com.worldvistaGestion.Entities.Connexion;
import com.worldvistaGestion.Entities.Depense;
import com.worldvistaGestion.Entities.Transaction;
import com.worldvistaGestion.Entities.User;
import com.worldvistaGestion.services.sup.serviceHoraire;
import com.worldvistaGestion.services.user.serviceCompte;
import com.worldvistaGestion.services.user.serviceConnexion;
import com.worldvistaGestion.services.user.serviceDepense;
import com.worldvistaGestion.services.user.serviceTransaction;
import com.worldvistaGestion.services.user.serviceUser;

@RestController
@CrossOrigin("*")
public class ApiUser {
	
	@Autowired
	serviceDepense _serviceDepense ;
	
	@Autowired
	serviceCompte _serviceCompte;
	
	@Autowired
	serviceConnexion _serviceConnexion ;
	
	@Autowired
	serviceTransaction _serviceTransaction ;
	
	@Autowired
	serviceUser _serviceUser;
	
	@Autowired
	serviceHoraire _serviceHoraire;
	
	
	Depense depense;
	
//	Methods for Depense
	
//	OK
	@PostMapping("/user/enregistrerDepense/depense")
	public void enregisterDepense(@RequestBody Depense depense) {
		_serviceDepense.enregisterDepense(depense);
	}
//	OK
	@GetMapping("/user/journalDepense/{idUser}")
	public List<Depense> getJournalDepense(@PathVariable Long idUser) {
		return _serviceDepense.getJournalDepenseById(idUser);
	}
	
//	Methods for Compte
	
//	OK
	@GetMapping("/user/updatePassword")
	public boolean updatePassword(@RequestParam Long idUser , @RequestParam String password) {
		return _serviceCompte.updatePassword(idUser,password);
	}
	
//	Methods for Connexion
	
//	OK
	@GetMapping("/user/getConnexion/{idUser}")
	public List<Connexion> getConnexion(@PathVariable(name="idUser") Long  idUser ) {
		return _serviceConnexion.findByUser(idUser);
	}
//	OK
	@GetMapping("/user/myLastConnexion/{idUser}")
	public  List<lastConnexion> myLastConnexion( @PathVariable(name="idUser") Long idUser) {
		return _serviceConnexion.myLastConnexion(idUser);
	}
//	OK
	@GetMapping("/user/myHistory/{idUser}")
	public List<historyConnexion> mesHistoriques(@PathVariable(name="idUser") Long idUser) {
		return _serviceConnexion.mesHistoriques(idUser);
	}
//	OK
	@GetMapping("/user/topConnexion")
	public List<Connexion> topConnexion() {
		return _serviceConnexion.topConnexion();
	}
//	NOT WORK
//	@GetMapping("/user/connexionByMonth")
//	public List<Connexion> connexionByMonth(Long idUser,LocalDate firstDate , LocalDate lastDate) {
//		lastDate = _serviceHoraire.today();
//		firstDate = LocalDate.parse("2020-02-12");
//		return _serviceConnexion.connexionParMois(idUser,firstDate, lastDate);
//	}
//	OK
	@GetMapping("/user/mylastDurationConnexion/{idUser}")
	public Long maDerniereDureeDeConnexion(@PathVariable Long idUser) {
		return _serviceConnexion.maDerniereDuree(idUser);
	}

	//	Methods for Transaction
	
//	OK
	@PostMapping("/user/deposit/transaction")
	public void Depot(@RequestBody Transaction transaction) {
		_serviceTransaction.faireDepot(transaction);
	}
//	OK
	@PostMapping("/user/withdrawal/transaction")
	public void retrait(@RequestBody Transaction transaction) {
		_serviceTransaction.faireRetrait(transaction);
	}
//	OK
	@GetMapping("/user/evolution")
	public Double getEvolutionTransaction() {
		return _serviceTransaction.getTransactionAvancement();
	}
//	OK
	@GetMapping("/user/seachTransactionByType/{typeTransaction}")
	public List<Transaction> chercherTransactionByType(@PathVariable(name="typeTransaction") String typeTransaction) {
		return _serviceTransaction.rechercheTransaction("%"+typeTransaction+"%");
	}
	
//	OK
	@GetMapping("/user/topTransaction/{idUser}")
	public Iterable<Transaction> topTransaction(@PathVariable Long idUser) {
		return _serviceTransaction.topTransaction(idUser);
	}
//	OK
	@GetMapping("/user/transactionDay/{today}")
	public Iterable<Transaction> transactionsDuJour(@PathVariable String today) {
		return _serviceTransaction.transactionsDuJour(LocalDate.parse(today));
	}
	
//	Methods for User
	
//	OK
	@GetMapping("/user/login/{idUser}/{password}")
	public boolean connecter(@PathVariable Long idUser , @PathVariable String password) {
		return _serviceUser.connecter(idUser, password);
	}
//	OK
	@PostMapping("/user/logout/{idUser}")
	public boolean deconnectser(@PathVariable Long idUser) {
		return _serviceUser.deconnecter(idUser);
	}
//	OK
	@PostMapping("/user/updateProfil/{user}")
	public User updateProfil(@RequestBody User user) {
		return _serviceUser.updateMonProfil(user);
	}
	
	
	}
	
	
