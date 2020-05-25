package com.worldvistaGestion.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.worldvistaGestion.Entities.Book;

public interface bookRepository extends JpaRepository<Book,Long>{
	
	@Query("select b.idBook ,  a.idAuteur from Book b , Auteur a where b.idBook =:idBook")
	List<Book> getBooksById(Long idBook);

}
