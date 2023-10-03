package com.majahar.pairprogramming.mapper;

import com.majahar.pairprogramming.dto.BookDTO;
import com.majahar.pairprogramming.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BookMapper {
	
	@Autowired
	ModelMapper modelMapper;
	
	public Book dtoToEntity(BookDTO bookDTO){
		return modelMapper.map(bookDTO,Book.class);
	}
	
	public BookDTO entityToDTO(Book book){
		return modelMapper.map(book, BookDTO.class);
	}
}
