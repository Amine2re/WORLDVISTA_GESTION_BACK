package com.worldvistaGestion.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.worldvista.Gestion.Pojo.historyConnexion;
import com.worldvistaGestion.Entities.Connexion;

public interface ConnexionRepository extends CrudRepository<Connexion, Long>{
	
	@Query("select c from Connexion c where c.idUser =:idUser")
	Page<Object> getTotalPageConnexion( Long idUser , Pageable page);
	
	@Query("select c from Connexion c where c.idUser =:idUser order by c.dateConnexion desc")
	 Iterable<Connexion> getAllHistory(Long idUser);
	
	@Query("select max(c.dateConnexion) from Connexion c where c.idUser =:idUser")
	 Object getDerniereConnexion(@Param("idUser") Long idUser);
	
	@Query("select c from Connexion c where c.idUser =:idUser order by c.dateConnexion , c.idConnexion  asc")
	 List<Connexion> connexionByUser(@Param("idUser") Long idUser );
	
	@Query("select c.dateConnexion from Connexion c where c.idUser =:idUser")
	List<LocalDate> lastDateConnexion(Long idUser);
	
	@Query("select max(c.heureConnexion) from Connexion c where c.idUser =:idUser and c.dateConnexion = (select max(con.dateConnexion) from Connexion con) ")
	Object lastHoursConnexion(Long idUser);
	
	@Query("select c.dureeConnexion from Connexion c where c.idUser =:idUser")
	Integer lastDureeConnexion(Long idUser);
	
	@Query("select c from Connexion c where c.idUser =:x and c.idCompte =:y and c.idConnexion = (select max(con.idConnexion) from Connexion con) ")
	 Connexion connexionByUserAndIdCompte(@Param("x") Long idUser , @Param("y") Long idCompte);
	
	@Query("select new com.worldvista.Gestion.Pojo.historyConnexion (c.dateConnexion,c.heureConnexion, c.idUser ) from Connexion c where c.idUser =:idUser order by c.dateConnexion desc")
	 List<historyConnexion> getMesHistoriquesDeConnexion(@Param("idUser") Long idUser , Pageable page);
	
	 @Query("select sum(c.nbConnexion) as nbConnexion, c.idCompte , round( (c.nbConnexion / (select sum(con.nbConnexion)  from Connexion con ))*100,2) as pourcentage from Connexion c  order by c.dateConnexion , c.heureConnexion desc")
	 List<Object> getTop5ConnexionByIdUser( Pageable page);
	 
//	@Query("select (select c from Connexion c where c.idUser :idUser) from Connexion  c where c.dateConnexion between :firstDate and :lastDate " )
//	public List<Connexion> filtreConnexionParMois(Long idUser , LocalDate firstDate, LocalDate lastDate);
//	
//	@NamedQuery(name="Program.findAll", query="SELECT p FROM Program p ")}
//	@Query("select c.idUser from Connexion c order by c.idConnexion desc limit 1")
//	public Object getIdConneted(); 
	 
	@Query("select max(c.dureeConnexion) from Connexion c where c.idUser =:idUser")
	public Long dureeDerniereConnexion(Long idUser);	
	
	@Query("select c from Connexion c order by c.nbConnexion , c.heureConnexion desc ")
	public List<Connexion> getTopConnexion();
 }
