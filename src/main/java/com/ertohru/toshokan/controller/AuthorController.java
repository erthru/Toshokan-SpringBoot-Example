package com.ertohru.toshokan.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ertohru.toshokan.repo.AuthorRepo;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorRepo authorRepo;
	
	@GetMapping("all")
	public LinkedHashMap<String, Object> all(Pageable page){
		
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		response.put("error", false);
		response.put("message", "success");
		response.put("data", authorRepo.findAll(page));
		
		return response;
		
	}
	
	@GetMapping("find/{book_id}")
	public LinkedHashMap<String, Object> byId(@PathVariable(value = "book_id") long bookId){
		
		LinkedHashMap<String, Object> response = new LinkedHashMap<>();
		response.put("error", false);
		response.put("message", "success");
		response.put("data", authorRepo.findById(bookId));
		
		return response;
		
	}
	
	
}
