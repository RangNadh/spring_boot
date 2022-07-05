package io.springboot.mongodb.connection.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.mongodb.connection.model.Book;
import io.springboot.mongodb.connection.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		bookRepo.save(book);
		return "Added book with id: " + book.getId();
	}
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return bookRepo.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Optional<Book> getBook(@PathVariable int id){
		return bookRepo.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		bookRepo.deleteById(id);
		return "Book deleted with id: " + id;
	}
}
