package com.ertohru.toshokan.controller;

import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ertohru.toshokan.model.Author;
import com.ertohru.toshokan.model.Book;
import com.ertohru.toshokan.repo.BookRepo;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookRepo bookRepo;
	
	@GetMapping("/")
	public LinkedHashMap<String, Object> index(){
		
		LinkedHashMap<String,Object> response = new LinkedHashMap<>();
		response.put("error", true);
		response.put("message", "bad request");
		
		return response;
	}
	
	@GetMapping("all")
	public LinkedHashMap<String, Object> all(Pageable page){
		
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		response.put("error", false);
		response.put("message", "success");
		response.put("data", bookRepo.findAll(page));
		
		return response;
		
	}
	
	@GetMapping("find/{book_id}")
	public LinkedHashMap<String, Object> find(@PathVariable(value = "book_id") long bookId){
		
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		response.put("error", false);
		response.put("message", "success");
		response.put("data", bookRepo.findById(bookId));
		
		return response;
		
	}
	
	@GetMapping("findbyauthor/{author_id}")
	public LinkedHashMap<String, Object> findByAuthor(@PathVariable(value = "author_id") long authorId, Pageable page){
		
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		response.put("error", false);
		response.put("message", "success");
		response.put("data", bookRepo.byAuthorId(authorId,page));
		
		return response;
		
	}
	
	@GetMapping("search")
	public LinkedHashMap<String, Object> search(@RequestParam("query") String query){
		
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		response.put("error", false);
		response.put("message", "success");
		response.put("data", bookRepo.search(query));
		
		return response;
		
	}
	
	@PutMapping("update/{book_id}")
	public LinkedHashMap<String, Object> update(
			@PathVariable("book_id") long bookId,
			@RequestParam("book_title") String bookTitle,
			@RequestParam("book_synopsis") String bookSynopsis,
			@RequestParam("author_id") long authorId){
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookTitle(bookTitle);
		book.setBookSynopsis(bookSynopsis);
		book.setAuthor(new Author(authorId,null,null));
		
		bookRepo.save(book);
		
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		response.put("error", false);
		response.put("message", "success");
		response.put("updated_values", book);
		return response;
	}
	
	@DeleteMapping("delete/{book_id}")
	public LinkedHashMap<String, Object> delete(
			@PathVariable("book_id") long bookId){
				
		Book book = new Book();
		book.setBookId(bookId);
		
		bookRepo.delete(book);
		
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		response.put("error", false);
		response.put("message", "success");
		return response;
	}
	
	@PostMapping("add")
	public LinkedHashMap<String, Object> add(
			@RequestParam("book_title") String bookTitle,
			@RequestParam("book_synopsis") String bookSynopsis,
			@RequestParam("author_id") long authorId){
		
		Book book = new Book();
		book.setBookTitle(bookTitle);
		book.setBookSynopsis(bookSynopsis);
		book.setAuthor(new Author(authorId,null,null));
		
		bookRepo.save(book);
		
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		response.put("error", false);
		response.put("message", "success");
		response.put("added_values", book);
		return response;
	}
	
	
	
}
