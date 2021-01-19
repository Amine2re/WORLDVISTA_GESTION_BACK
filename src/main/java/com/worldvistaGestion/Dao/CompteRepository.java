package com.worldvistaGestion.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.worldvistaGestion.Entities.Compte;
public interface CompteRepository extends CrudRepository<Compte, Long>{
	@Query("select c from Compte c where c.idUser =:x")
	Optional<Compte> findByIdUser(@Param("x") Long idUser);
	
}
