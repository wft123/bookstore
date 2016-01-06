package com.bit.bookstore.model;

public class Magazine extends Book{
	
	// Member Variable
	private int year;
	private int month;
	
	// Constructors
	public Magazine() {}

	public Magazine(String isbn, String title, String author, String publisher,
			int year, int month, int cost, int price, int quantity) {
		super(isbn, title, author, publisher, cost, price, quantity);
		setYear(year);
		setMonth(month);
	}
	
	public Magazine(String isbn, String title, String author, String publisher,
			int year, int month, int cost, int price, int quantity, String desc) {
		super(isbn, title, author, publisher, cost, price, quantity,desc);
		setYear(year);
		setMonth(month);
	}
	

	// Methods
	@Override
	public String toString() {
		return super.toString()+"\t|"+year+"."+month;
	}

	
	// Getters & Setters
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	
}
