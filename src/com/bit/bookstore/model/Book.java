package com.bit.bookstore.model;

public class Book {
	
	// Member Variables
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String desc;
	private int cost;
	private int price;
	private int quantity;
	
	// Constructors
	public Book(){};
	
	public Book(String isbn,String title, String author, String publisher, int cost, int price, int quantity){
		setIsbn(isbn);
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setCost(cost);
		setPrice(price);
		setQuantity(quantity);
		setDesc(desc);
	}
	public Book(String isbn,String title, String author, String publisher, int cost, int price, int quantity,String desc){
		setIsbn(isbn);
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setCost(cost);
		setPrice(price);
		setQuantity(quantity);
		setDesc(desc);
	}
	
	// Methods
	public int getAmount(){
		return price*quantity;
	}
	
	@Override
	public String toString() {
		return isbn+"\t|"+title+"\t|"+author+"\t|"+publisher+"\t|"+price+"\t|"+desc;
	}
	
	// Getters & Setters
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		if(desc==null) desc = " ";
		this.desc = desc;
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
