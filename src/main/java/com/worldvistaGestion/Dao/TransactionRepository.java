package com.worldvistaGestion.Dao;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.worldvista.Gestion.Pojo.transac;
import com.worldvistaGestion.Entities.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{
	
	//for Admin
	
	@Query("select sum(t.mtTransaction) as Total_Transaction from Transaction t where t.idUser =:idUser")
	 Double getTotalTransaction(Long idUser);
	
	//for User and Admin
	
	@Query("select sum(t.commission) as Total_Transaction from Transaction t ")
	 int getStatusCommission();
	
	//for User and Admin
	
	@Query("select sum(t.commission) as Total_Transaction from Transaction t where t.idUser =:idUser")
	 Double getStatusCommissionByUser(Long idUser);
	
	//for Admin && User
	
	@Query("select NEW com.worldvista.Gestion.Pojo.transac( t.idTransaction , t.dateTransaction , t.typeTransaction , t.mtTransaction,t.commission) from Transaction t where t.dateTransaction =:x order by t.mtTransaction desc")
	 Iterable<Transaction> getAllTransactionDuJour(@Param("x")LocalDate dateDuJour);
	
	//for Admin && User
	
	@Query("select NEW com.worldvista.Gestion.Pojo.transac(t.idTransaction , t.dateTransaction , t.typeTransaction , t.mtTransaction , t.commission) from Transaction t where t.dateTransaction =:x and t.idUser =:y order by t.mtTransaction desc")
	 Iterable<transac> getAllTransactionDuJourById(@Param("x")LocalDate dateDuJour , @Param("y") Long idUser);
	
	//for Admin 
	 
	@Query("select sum(t.mtTransaction) from Transaction t")
	 Double getTransactionAvancement();
	
	//for Admin 
	
	@Query("select t from Transaction t where t.idUser =:idUser order by t.mtTransaction  desc")
	 List<Transaction> getTopTransactionById(Long idUser, Pageable pageRequest);
	
	// for Admin 
	
	@Query("select t from Transaction t order by t.dateTransaction desc")
	public Iterable<Transaction> getTransactionByOrderDate();
	
	//	for Admin & User
	List<Transaction> findByIdUser(Long idUser);
	
	@Query("select count(t.idTransaction) from Transaction t where t.idUser =:idUser")
	Integer getNbTransactionByUser (Long idUser);
	
	
	//	for admin
	
	@Query("select t from Transaction t order by t.mtTransaction desc")
	Iterable<Transaction> topTransaction();
	
	//for User
	
	@Query("select t from Transaction t where t.typeTransaction like :x order by t.mtTransaction desc")
	List<Transaction> rechercheTransactionByType(@Param("x") String typeTransaction);
	
	//for Admin
	
	@Query("select sum(t.mtTransaction) as totalTransctionMensuelle from Transaction t where t.dateTransaction between :firstDate and :lastDate order by t.mtTransaction desc")
	 Object getMtTransactionMensuel(LocalDate firstDate , LocalDate lastDate);
	
	//for Admin and User
	
	@Query("select t from Transaction t where t.idUser =:idUser order by t.dateTransaction desc ")
	Page<Transaction> getTotalPageTransac(Long idUser,Pageable page);

	//for Admin and User
	
	@Query("select t from Transaction t where t.idUser =:idUser order by t.dateTransaction desc")
	List<Transaction> getAllTransactionById(Long idUser, Pageable page);	
}
