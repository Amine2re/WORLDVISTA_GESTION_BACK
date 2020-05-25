package com.worldvistaGestion.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.worldvista.Gestion.Pojo.historyConnexion;
import com.worldvista.Gestion.Pojo.lastConnexion;
import com.worldvistaGestion.Entities.Connexion;

public interface ConnexionRepository extends CrudRepository<Connexion, Long>{
	
	@Query("select NEW com.worldvista.Gestion.Pojo.lastConnexion (max(c.dateConnexion) , max(c.heureConnexion)) 	from Connexion c where c.idUser =:idUser")
	 List<lastConnexion> getDerniereConnexion(@Param("idUser") Long idUser);
	
	@Query("select c from Connexion c where c.idUser =:idUser")
	 List<Connexion> connexionByUser(@Param("idUser") Long idUser);
	
	@Query("select c from Connexion c where c.idUser =:x and c.idCompte =:y")
	 Connexion connexionByUserAndIdCompte(@Param("x") Long idUser , @Param("y") Long idCompte);
	
	@Query("select new com.worldvista.Gestion.Pojo.historyConnexion (c.dateConnexion,c.heureConnexion, c.idUser ) from Connexion c where c.idUser =:idUser")
	 List<historyConnexion> getMesHistoriquesDeConnexion(@Param("idUser") Long idUser);
	
//	@Query("select (select c from Connexion c where c.idUser :idUser) from Connexion  c where c.dateConnexion between :firstDate and :lastDate " )
//	public List<Connexion> filtreConnexionParMois(Long idUser , LocalDate firstDate, LocalDate lastDate);
	
	@Query("select max(c.dureeConnexion) from Connexion c where c.idUser =:idUser")
	public Long dureeDerniereConnexion(Long idUser);	
	
	@Query("select c from Connexion c order by c.nbConnexion desc ")
	public List<Connexion> getTopConnexion();
 }
