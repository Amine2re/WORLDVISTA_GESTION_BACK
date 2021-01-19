package com.worldvistaGestion.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.worldvistaGestion.Entities.Depense;

public interface DepenseRepository extends JpaRepository<Depense, Long>{
	//for Admin && User
	@Query("select d from Depense d where d.idUser =:idUser")
	Page<Depense> totalPage(Long idUser , Pageable pageRequest);
	
	// for Admin && User
	@Query("select sum(d.MtDepense) from Depense d where d.idUser =:x")
	 Double getTotalDepense(@Param("x") Long idUser);
	
	//for Admin && User
	@Query("select d from Depense d where d.idUser =:idUser")
	List<Depense> findByIdUserPage(@Param("idUser") Long idUser , Pageable pageRequest );
	
	//for Admin && User
		@Query("select d from Depense d where d.idUser =:idUser")
		List<Depense> findDepenseByIdUser(@Param("idUser") Long idUser);
	
	// for Admin && User
	@Query("select sum(d.MtDepense) from Depense d where d.dateDepense between :firstDate and :lastDate ")
	 Object getTotalDepenseParMois(@Param("firstDate") LocalDate firstDate , @Param("lastDate") LocalDate lastDate);
	
	//for Admin && User
	@Query("select count(d.idUser) from Depense d where d.idUser =:idUser")
	List<Object> nbDepenseById(@Param("idUser") Long idUser);

}
