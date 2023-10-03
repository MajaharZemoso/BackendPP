package com.majahar.pairprogramming.service;

import com.majahar.pairprogramming.dto.BookDTO;

import java.util.List;

public interface BookService {
	
	List<BookDTO> findAll();
	BookDTO findById(Long id);
	String save(BookDTO bookDTO);
	String update(Long id,BookDTO bookDTO);
	String delete(Long id);
	
	List<BookDTO> findByAuthorName(String authorName);
	
}
