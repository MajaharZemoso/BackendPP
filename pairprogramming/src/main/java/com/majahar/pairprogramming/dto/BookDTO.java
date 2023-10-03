package com.majahar.pairprogramming.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDTO {
	private Long id;
	private String authorName;
	private Integer ISBN;
	private Date publicationDate;
}
