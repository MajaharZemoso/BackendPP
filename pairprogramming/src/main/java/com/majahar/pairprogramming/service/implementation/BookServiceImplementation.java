package com.majahar.pairprogramming.service.implementation;

import com.majahar.pairprogramming.dto.BookDTO;
import com.majahar.pairprogramming.entity.Book;
import com.majahar.pairprogramming.exception.BookNotFoundException;
import com.majahar.pairprogramming.mapper.BookMapper;
import com.majahar.pairprogramming.repository.BookRepository;
import com.majahar.pairprogramming.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookServiceImplementation implements BookService {
	
	BookRepository bookRepository;
	
	BookMapper bookMapper;
	
	@Autowired
	public BookServiceImplementation(BookRepository bookRepository, BookMapper bookMapper) {
		this.bookRepository = bookRepository;
		this.bookMapper = bookMapper;
	}
	
	@Override
	public List<BookDTO> findAll() {
		log.info("Inside the findAllBook function in service layer");
		List<Book> bookList = bookRepository.findAll();
		return bookList.stream()
				.map(bookMapper::entityToDTO)
				.toList();
	}
	
	@Override
	public BookDTO findById(Long id) {
		log.info("Inside the findById function in service layer");
		Optional<Book> result = bookRepository.findById(id);
		if(result.isPresent()){
			return bookMapper.entityToDTO(result.get());
		}
		else{
			throw new BookNotFoundException("No book find with that ID");
		}
	}
	
	@Override
	public String save(BookDTO bookDTO) {
		log.info("Inside the save function in service layer");
		bookMapper.entityToDTO(bookRepository.save(bookMapper.dtoToEntity(bookDTO)));
		return "Book saved successfully";
	}
	
	@Override
	public String update(Long id, BookDTO bookDTO) {
		log.info("Inside the update function in service layer");
		Book existingBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with that id not found"));
		existingBook.setAuthorName(bookDTO.getAuthorName());
		existingBook.setISBN(bookDTO.getISBN());
		existingBook.setPublicationDate(bookDTO.getPublicationDate());
		
		bookMapper.entityToDTO(bookRepository.save(existingBook));
		return "Book updated";
	}
	
	@Override
	public String delete(Long id) {
		log.info("Inside the delete function in service layer");
		Book existingBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with that id not found"));
		bookRepository.delete(existingBook);
		return "Book Deleted successfully";
	}
	
	@Override
	public List<BookDTO> findByAuthorName(String authorName) {
		List<Book> bookList = bookRepository.findByAuthorName(authorName);
		return bookList.stream().map(bookMapper::entityToDTO)
				.toList();
	}
}
