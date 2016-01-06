package com.bit.bookstore.controller;

import java.util.List;

import com.bit.bookstore.model.Book;

public interface ILibrary {
	
	void add(Book b);
	void add(String isbn,String title, String author, String publicher, int cost, int price, int quantity);
	void remove(String isbn);
	void allList();
	List<Book> getList();
	void bookList();
	void magazineList();
	void educationList();
	Book search(String isbn);
	int size();
	boolean sell(String isbn, int quantity);
	boolean buy(String isbn, int quantity);
	long getTotalAmount();
	
}
