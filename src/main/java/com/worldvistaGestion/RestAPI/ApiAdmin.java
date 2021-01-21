package com.worldvistaGestion.RestAPI;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.worldvista.Gestion.Pojo.fullUser;
import com.worldvistaGestion.Entities.Compte;
import com.worldvistaGestion.Entities.Connexion;
import com.worldvistaGestion.Entities.Depense;
import com.worldvistaGestion.Entities.Transaction;
import com.worldvistaGestion.Entities.User;
import com.worldvistaGestion.services.admin.serviceCompteAdmin;
import com.worldvistaGestion.services.admin.serviceConnexionAdmin;
import com.worldvistaGestion.services.admin.serviceDepenseAdmin;
import com.worldvistaGestion.services.admin.serviceTransactionAdmin;
import com.worldvistaGestion.services.admin.serviceUserAdmin;

@RestController
@CrossOrigin("*")
public class ApiAdmin {
	
	@Autowired
	serviceDepenseAdmin _serviceDepense;
	
	@Autowired
	serviceCompteAdmin _serviceCompte;
	
	@Autowired
	serviceTransactionAdmin _serviceTransac;
	
	@Autowired
	serviceUserAdmin _serviceUser;
	
	@Autowired
	serviceConnexionAdmin _serviceConnexionAdmin;
	
	//  Methods for Depenses
	
//		OK
		@PostMapping("/admin/depense/supprimer/{idDepense}")
		public void supprimerDepense(@PathVariable Long idDepense) {
			_serviceDepense.suppimerDepense(idDepense);
		}
//		OK
		@PostMapping("/admin/depense/update/depense")
		public void updateDepense(@RequestBody Depense depense) {
			_serviceDepense.updateDepense(depense);
		}
//		OK
		@GetMapping("/admin/depense/totalMensuelle/{firstDate}/{lastDate}")
		public Object totalDepenseMensuelle(@PathVariable String firstDate , @PathVariable String lastDate) {
			return _serviceDepense.totalDepenseMensuelle(firstDate, lastDate);
		}
//		OK
		@GetMapping("/admin/depense/totalDepense/{idUser}")
		public Double totalDepenseById(@PathVariable Long idUser) {
			return _serviceDepense.totalDepenseById(idUser);
		}
		
	//  Methods for Compte
//		OK
		@GetMapping("/admin/compte/getComptes")
		public Iterable<Compte> getComptes(){
			return _serviceCompte.getAllCompte();
		}
//		OK
		@PostMapping("/admin/compte/supprimer/{idCompte}")
		public void supprimerCompte(@PathVariable Long idCompte) {
			 _serviceCompte.supprimerCompte(idCompte);
		}
//		OK
		@GetMapping("/admin/compte/activer/{idCompte}")
		public boolean activerCompte(@PathVariable Long idCompte) {
			 return _serviceCompte.activerCompte(idCompte);
		}
//		OK
		@GetMapping("/admin/compte/desactiver/{idCompte}")
		public boolean desactiverCompte(@PathVariable Long idCompte) {
			 return _serviceCompte.desactiverCompte(idCompte);
		}
	
	//	Methods for Transaction
//		OK
		@PostMapping("/admin/transaction/supprimer/{idTransaction}")
		public void supprimerTransaction(@PathVariable Long idTransaction) {
			 _serviceTransac.suppimerTransaction(idTransaction);
		}
		
//		OK
		@GetMapping("/admin/transaction/updateTransaction")
		public boolean updateTransaction(@RequestBody Transaction transaction) {
			return _serviceTransac.updateTransaction(transaction);
		}
		
//		OK
		@GetMapping("/admin/transaction/transactionsDuJour/{today}")
		public Iterable<Transaction> transactionsDuJour(@PathVariable String today) {
			return _serviceTransac.transactionsDuJour(LocalDate.parse(today));
		}
		
//		OK
		@GetMapping("/admin/transaction/evolution")
		public Double evolutionTransaction() {
			return _serviceTransac.getEvolutionTransactions();
		}
		
//		OK
		@GetMapping("/admin/transaction/topTransactions")
		public Iterable<Transaction> getTopTransactions(){
			return _serviceTransac.getTopTransaction();
		}
		
//		OK
		@GetMapping("/admin/transaction/topTransactionById/{idUser}")
		public Iterable<Transaction> getTopTransactionById(@PathVariable Long idUser){
			return _serviceTransac.getTopTransactionById(idUser);
		}
//		OK
		@GetMapping("/admin/transaction/findTransactionByType/{typeTransaction")
		public Iterable<Transaction> findTransacByType(@PathVariable String typeTransaction){
			return _serviceTransac.searchTransactionByType(typeTransaction);
		}
		
//		OK
		@GetMapping("/admin/transaction/getTransactions")
		public Iterable<Transaction> getTransactions(){
			return _serviceTransac.getAllTransactionByOrder();
		}
		
//		OK
		@GetMapping("/admin/transaction/montantTransactionMensuelle")
		public Object mtTransactionMensuelle(@PathVariable String firstDate , @PathVariable String lastDate) {
			return _serviceTransac.getMtTranctionMensuelle(firstDate, lastDate);
		}
		
	//	Methods for User
//		OK
		@PostMapping("/admin/creerUser/user")
		public void creerUser(@RequestBody User user) {
			_serviceUser.ceerUser(user);
		}
//		OK
		@GetMapping("/admin/rechercher/{idUser}")
		public Optional<User> rechercherUser(@PathVariable Long idUser) {
			return _serviceUser.rechercherUser(idUser);
		}
//		OK
		@GetMapping("/admin/getAllUsers")
		public Iterable<User> getAllUsers() {	
			return _serviceUser.getAllUser();
		}
		
//		OK
		
		@GetMapping("/admin/getFullUser/{idUser}")
		public Iterable<fullUser> getFullUser(@PathVariable Long idUser) {
			return _serviceUser.getFullUserInformation(idUser); 	
		}
		
		
		
//		Methods for Connexion
		
//		OK
		
//		@GetMapping("/admin/getAllConnexions")
//		public Iterable<Connexion> getConnexions(Long idUser) {
//			return _serviceConnexionAdmin.getAllConnexions(idUser);
//		}
}