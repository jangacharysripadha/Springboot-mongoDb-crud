package com.chary.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chary.springboot.model.Book;
import com.chary.springboot.repositories.BookRepository;

@RestController
@RequestMapping("api")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book)
	{
		bookRepository.save(book);
		return "Added Book with id:"+book.getId();
	}
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks()
	{
		return bookRepository.findAll();
	}
	
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBooksById(@PathVariable int id)
	{
		return bookRepository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id)
	{
		bookRepository.deleteById(id);
		return "book deleted with id:"+id;
	}

	
	
	

}
