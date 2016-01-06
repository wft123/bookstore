package com.bit.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import com.bit.bookstore.model.Book;
import com.bit.bookstore.model.Education;
import com.bit.bookstore.model.Magazine;
import com.bit.bookstore.test.Constants;

public class Buyer implements ILibrary{
	
	private static ILibrary lm = null;
	ArrayList<Book> books;
	
	private Buyer(){
		this.books = Constants.books;
	}
	
	public static ILibrary getInstance(){
		if(lm==null) lm = new Buyer();
		return lm;
	}

	@Override
	public void add(Book b) {
		System.out.println("입고자는 이 권한이 없습니다.");
	}

	@Override
	public void add(String isbn, String title, String author, String publicher, int cost, int price, int quantity) {
		System.out.println("입고자는 이 권한이 없습니다.");
	}

	@Override
	public void remove(String isbn) {
		System.out.println("입고자는 이 권한이 없습니다.");
	}

	@Override
	public void allList() {
		for(Book b : books){
			System.out.println(b);
		}
	}

	@Override
	public void bookList() {
		for(Book b : books){
			if(b.getClass().getSimpleName().equals("Book")){
				System.out.println(b);
			}
		}
	}

	@Override
	public void magazineList() {
		for(Book b : books){
			if(b instanceof Magazine){
				System.out.println(((Magazine)b));
			}
		}
	}
	
	@Override
	public void educationList() {
		for(Book b : books){
			if(b instanceof Education){
				System.out.println(((Education)b));
			}
		}
	}

	@Override
	public Book search(String isbn) {
		for(Book b : books){
			if(b.getIsbn().equals(isbn)){
				return b;
			}
		}
		System.out.println("등록되지 않은 ISBN 입니다.");
		return null;
	}

	@Override
	public int size() {
		return books.size();
	}

	@Override
	public boolean sell(String isbn, int quantity) {
		System.out.println("입고자는 이 권한이 없습니다.");
		return false;
	}

	@Override
	public boolean buy(String isbn, int quantity) {
		for(Book b : books){
			if(b.getIsbn().equals(isbn)){
				if(Constants.capitalStock > b.getPrice()*quantity){
					b.setQuantity(b.getQuantity()+quantity);
					Constants.capitalStock -= b.getPrice()*quantity;
					System.out.println(b.getTitle()+"이 정상 입고 되었습니다.");
				}else{
					System.out.println("자본금이 부족합니다.");
				}
				return true;
			}
		}
		System.out.println(isbn+"는 등록된 도서가 아니어서 입고할 수 없습니다.");
		return false;
	}

	@Override
	public long getTotalAmount() {
		long total = 0;
		for(Book b : books){
			total += b.getPrice()*b.getQuantity();
		}
		return total;
	}

	@Override
	public List getList() {
		return books;
	}

}
