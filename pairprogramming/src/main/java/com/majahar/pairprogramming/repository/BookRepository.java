package com.majahar.pairprogramming.repository;

import com.majahar.pairprogramming.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("SELECT b FROM Book b WHERE b.authorName = :authorName")
	public List<Book> findByAuthorName(@Param("authorName") String authorName);
	
}
