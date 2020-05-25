package com.worldvistaGestion.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.worldvistaGestion.Entities.Depense;

public interface DepenseRepository extends JpaRepository<Depense, Long>{
	
	// for Admin && User
	@Query("select sum(d.MtDepense) from Depense d where d.idUser =:x")
	 Double getTotalDepense(@Param("x") Long idUser);
	
	//for Admin && User
	// public Double getMoyenneDepense(); 
	
	List<Depense> findByIdUser(Long idUser);
	
	// for Admin && User
	@Query("select sum(d.MtDepense) from Depense d where d.dateDepense between :firstDate and :lastDate ")
	 Object getTotalDepenseParMois(@Param("firstDate") LocalDate firstDate , @Param("lastDate") LocalDate lastDate);

}
