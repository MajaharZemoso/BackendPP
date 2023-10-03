package com.majahar.pairprogramming.exception;

public class BookNotFoundException extends RuntimeException{
	public BookNotFoundException(String message){
		super(message);
	}
}
