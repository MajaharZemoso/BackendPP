package com.majahar.pairprogramming.controller;

import com.majahar.pairprogramming.dto.BookDTO;
import com.majahar.pairprogramming.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.majahar.pairprogramming.utils.AppConstants.BASE_URL;

@Slf4j
@RestController
@RequestMapping(BASE_URL)
public class BookController {
	
	BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public List<BookDTO> getAll(){
		log.info("Inside the getAll function in controller layer");
		return bookService.findAll();
	}
	
	@GetMapping("/{id}")
	public BookDTO getById(@PathVariable Long id){
		log.info("Inside the getById function in controller layer");
		return bookService.findById(id);
	}

	@GetMapping("/{authorName}")
	public List<BookDTO> getById(@PathVariable String authorName){
		log.info("Inside the getById function in controller layer");
		return bookService.findByAuthorName(authorName);
	}
	
	@PostMapping
	public String save(@RequestBody BookDTO bookDTO){
		log.info("Inside the save function in controller layer");
		return bookService.save(bookDTO);
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable Long id, @RequestBody BookDTO bookDTO){
		log.info("Inside the update function in controller layer");
		return bookService.update(id,bookDTO);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id){
		log.info("Inside the delete function in controller layer");
		return bookService.delete(id);
	}
}
