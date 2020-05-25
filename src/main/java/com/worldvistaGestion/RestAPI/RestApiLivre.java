package com.worldvistaGestion.RestAPI;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.worldvistaGestion.Dao.autorRepository;
import com.worldvistaGestion.Dao.bookRepository;
import com.worldvistaGestion.Entities.Auteur;
import com.worldvistaGestion.Entities.Book;

@RestController

public class RestApiLivre {
	
	@Autowired
	autorRepository auteurRepos ;
	
	@Autowired
	bookRepository bookRepos ;
	
	Book book;
	
	Auteur auteur ;
	
	List<Book> lsBook ;
	
	@PostMapping("/createAuteur")
	public Auteur createAuteur( @RequestBody Auteur auteur) {
		return auteurRepos.save(auteur);
	}
	
	@PostMapping("/createBook/{idAuteur}/book")
	public Book createBook(@PathVariable Long idAuteur , @RequestBody Book book) {
		
		Set<Book> books = new HashSet<>();
		Optional<Auteur> autById = auteurRepos.findById(idAuteur);
		
		if(autById.isPresent()) {
			
			auteur = autById.get();
			book.setAuteur(auteur);	
			bookRepos.save(book);
			
			books.add(book);
			auteur.setBookListe(books);
			
		}
		return book;
	}
	
	@GetMapping("/book/getBooks/{idBook}")
	public List<Book> getBooksById(@PathVariable Long idBook){
		return bookRepos.getBooksById(idBook);
	}
	
	@GetMapping("/getBook/{idBook}")
	public Optional<Book> getBook(@PathVariable Long idBook) {
		return bookRepos.findById(idBook);
	}
	
	@PostMapping("/updateBook/{idBook}")
	public Book updateBook(@PathVariable Long idBook) {
		Optional<Book> optionalBook = bookRepos.findById(idBook);
		if(optionalBook.isPresent()) {
			book = optionalBook.get();
			book.setNomBook("Mamy Dior");
			bookRepos.save(book);
		}
		return book;
	}
	
	@GetMapping("/getAuteur/{idAuteur}")
	public Optional<Auteur> getAuteur(@PathVariable Long idAuteur) {
		return auteurRepos.findById(idAuteur);
	}

}
