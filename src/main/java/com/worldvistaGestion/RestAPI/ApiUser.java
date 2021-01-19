package com.worldvistaGestion.RestAPI;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.worldvista.Gestion.Pojo.historyConnexion;
import com.worldvista.Gestion.Pojo.transac;
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
	@PostMapping("/user/enregistrerDepense")
	public void enregisterDepense(@RequestBody Depense depense) {
		_serviceDepense.enregisterDepense(depense);
	}
//	OK
	@GetMapping("/user/journalDepense/{idUser}/{page}")
	public List<Depense> getJournalDepense(@PathVariable Long idUser , @PathVariable int page) {
		return _serviceDepense.getJournalDepenseById(idUser,page);
	}
//	OK
	@GetMapping("/user/getNbDepenseByIdUser/{idUser}")
	public List<Object> nombreDepenseByIdUser(@PathVariable Long idUser) {
		return _serviceDepense.nbDepense(idUser);
	}
//	OK
	@GetMapping("/user/totalDepenseByIdUser/{idUser}")
	public double totalDepenseById(@PathVariable Long idUser) {
		return _serviceDepense.totalDepenseById(idUser);
	}
//	OK
	@GetMapping("/user/findDepensesByIdUser/{idUser}")
	public Iterable<Depense> getDepensesByIdUser(@PathVariable Long idUser ) {
		return _serviceDepense.getDepenseByIdUser(idUser);
	}
	
	@GetMapping("/user/getTotalPageDepense/{idUser}")
	public Object nbPageDepense(@PathVariable Long idUser){
		return _serviceDepense.getTotalPage(idUser,0);
	}
//	Methods for Compte
	
//	OK
	@GetMapping("/user/updatePassword")
	public boolean updatePassword(@RequestParam Long idUser , @RequestParam String password) {
		return _serviceCompte.updatePassword(idUser,password);
	}
	
//	OK
	@GetMapping("/user/getCompte/{idUser}")
	public Object getCompte(@PathVariable Long idUser) {
		return _serviceCompte.getCompteInformations(idUser);
	}

	
//	Methods for Connexion
	
//	OK
	
	@GetMapping("/user/getConnexions/{idUser}")
	public List<Connexion> getConnexionsById(@PathVariable(name="idUser") Long  idUser ) {
		return _serviceConnexion.findByUser(idUser);
	}
	
// OK
	
	@GetMapping("/user/getTopConnexion")
	public List<Object> getTopConnexionId(){
		return _serviceConnexion.top5ConnexionByIdUser();
	}
	
//	OK
	
	@GetMapping("/getToday")
	public LocalDate today() {
		return _serviceHoraire.today();
	}
	
//	OK
	
	@GetMapping("/user/getTotalPageConnexion/{idUser}")
	public Object getTotalPage(@PathVariable Long idUser) {
		return _serviceConnexion.getTotalPageConnexionById(idUser);
	}
	
//	OK
	
	@GetMapping("/user/myHistory/{idUser}/{page}")
	public List<historyConnexion> mesHistoriques(@PathVariable(name="idUser") Long idUser , @PathVariable int page) {
		return _serviceConnexion.mesHistoriques(idUser,page);
	}
	
//	OK
	
	@GetMapping("/user/topConnexion")
	public List<Connexion> topConnexion() {
		return _serviceConnexion.topConnexion();
	}
	
	@GetMapping("/user/actualConnected")
	public Long actualConnected(){
		return _serviceConnexion.getIdConnected().get(0).getIdUser();
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
	public Integer maDerniereDureeDeConnexion(@PathVariable Long idUser) {
		return _serviceConnexion.getDureeConnexionByIdUser(idUser);
	}
	
//	OK 
	
	@GetMapping("/user/getDateConnexion/{idUser}")
	public Object getDateConnexionByIdUser(@PathVariable Long idUser) {
		return _serviceConnexion.myLastConnexion(idUser);
	}
	
//	OK 
	
	@GetMapping("/user/getTimeConnexion/{idUser}")
	public Object getHeureConnexionByIdUser(@PathVariable Long idUser) {
		return _serviceConnexion.getHeureConnexionByIdUser(idUser);
	}
	
	@GetMapping("/user/fixDureeConnexion/{idUser}")
	public boolean fixDureeConnexion(@PathVariable Long idUser) {
		return _serviceUser.fixDureeConnexion(idUser);
	}

	//	Methods for Transaction
	
//	OK
	@PostMapping("/user/newTransaction")
	public void newTransaction(@RequestBody Transaction transaction) {
		_serviceTransaction.newTransaction(transaction);
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
	@GetMapping("/user/transactionDay")
	public Iterable<Transaction> transactionsDuJour() {
		return _serviceTransaction.transactionsDuJour();
	}
	
	//OK
	
	@GetMapping("/user/transactionDay/{idUser}")
	public Iterable<transac> transactionsDuJourById(@PathVariable Long idUser) {
		return _serviceTransaction.transactionsDuJourById(idUser);
	}
	
	@GetMapping("/user/transactionByIdUser/{idUser}/{page}")
	public Object transactionsById(@PathVariable Long idUser,@PathVariable int page) {
		return _serviceTransaction.transactionsById(idUser,page);
	}
	
//	OK
	
	@GetMapping("/user/getNbPageTransaction/{idUser}")
	public Object getTotalPageTransaction(@PathVariable Long idUser) {
		return _serviceTransaction.getTotalTransaction(idUser);
	}
	
	
	
//	Methods for User
	
//	OK
	@GetMapping("/user/login/{idUser}/{password}")
	public boolean connecter(@PathVariable Long idUser , @PathVariable String password) {
		return _serviceUser.connecter(idUser, password);
	}
	
//	OK
	
	@GetMapping("/user/logout/{idUser}")
	public boolean deconnectUser(@PathVariable Long idUser) {
		return _serviceUser.deconnecter(idUser);
	}
	
//	OK
	
	@GetMapping("/user/getUser/{idUser}")
	public Object getUser(@PathVariable Long idUser) {
		return _serviceUser.getUserInformations(idUser);
	}
	
//	OK
	
	@PostMapping("/user/updateProfil/{user}")
	public User updateProfil(@RequestBody User user) {
		return _serviceUser.updateMonProfil(user);
	}
	
//	OK
	
	@GetMapping("/user/getNbTransactionByIdUser/{idUser}")
	public Integer getNbTransactionByUser(@PathVariable Long idUser) {
		return _serviceTransaction.getNombreTransactionById(idUser);
	}

	@GetMapping("/user/totalCommissionByIdUser/{idUser}")
	public double totalCommissionByIdUser(@PathVariable Long idUser) {
		return _serviceTransaction.getStatusCommissionByUser(idUser);
	}
	
	@GetMapping("/user/totalCommission")
	public int totalCommmission() {
		return _serviceTransaction.getStatusCommission();
	}
	

	
	}
	
	
