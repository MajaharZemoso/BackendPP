package com.majahar.pairprogramming.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "authorName")
	private String authorName;
	
	@Column(name = "ISBN")
	private Integer ISBN;
	
	@Column(name = "publicationDate")
	private Date publicationDate;
	
	
}
