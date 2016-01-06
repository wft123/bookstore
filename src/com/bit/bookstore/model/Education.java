package com.bit.bookstore.model;

public class Education extends Book{

	private String major;
	
	public Education() {
	}

	public Education(String isbn, String title, String author, String publisher, int cost, int price, int quantity, String major) {
		super(isbn, title, author, publisher, cost, price, quantity);
		setMajor(major);
	}
	
	public Education(String isbn, String title, String author, String publisher, int cost, int price, int quantity, String desc,String major ) {
		super(isbn, title, author, publisher, cost, price, quantity,desc);
		setMajor(major);
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// Methods
		@Override
		public String toString() {
			return super.toString()+"\t|"+major;
		}
	
}
