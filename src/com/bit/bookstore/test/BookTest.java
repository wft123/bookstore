package com.bit.bookstore.test;

import com.bit.bookstore.model.Book;
import com.bit.bookstore.model.Education;
import com.bit.bookstore.model.Magazine;
import com.bit.bookstore.view.BookStoreView;

public class BookTest {
	
	public static void main(String[] args) {
		dummyData();
		
		BookStoreView bsv = new BookStoreView();
		bsv.selectManager();
		
	}
	
	public static void dummyData(){
		Constants.books.add(new Book("21424","Java Basic","김하나","자엔출판",5000,15000,1,"Java 기본 문법"));
		Constants.books.add(new Book("33455","JDBC Pro","김철수","자엔출판",8000,23000,1));
		Constants.books.add(new Book("55355","Servlet/JSP","박자바","자엔출판",9000,41000,1,"Model2 기반"));
		Constants.books.add(new Magazine("35535","Java World","편집부","자엔출판",2014,7,3000,7000,40));
		Constants.books.add(new Magazine("75342","Next Web","편집부","자엔출판",2014,5,2000,12000,1,"Ajax 소개"));
		Constants.books.add(new Magazine("76534","Data Modeling","편집부","자엔출판",2014,6,2000,8000,1,"Java System"));
		Constants.books.add(new Education("81245","토비의 스프링 3.1 1권","이일민","에이콘",18000,40000,10,"Programing"));
		Constants.books.add(new Education("54654","토비의 스프링 3.1 2권","이일민","에이콘",16000,35000,10,"Programing"));
	}
}
