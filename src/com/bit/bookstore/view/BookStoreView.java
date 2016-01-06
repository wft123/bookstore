package com.bit.bookstore.view;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import com.bit.bookstore.controller.Buyer;
import com.bit.bookstore.controller.ILibrary;
import com.bit.bookstore.controller.LibraryManagement;
import com.bit.bookstore.controller.Seller;
import com.bit.bookstore.model.Book;
import com.bit.bookstore.model.Education;
import com.bit.bookstore.model.Magazine;
import com.bit.bookstore.test.Constants;

public class BookStoreView {
	public static ILibrary lm =null;
	
	public void selectManager(){
		Scanner sc = new Scanner(System.in);
		System.out.println("******** 관리자 선택 *************");
		System.out.println("********1. 총 관리자 *************");
		System.out.println("********2. 입고 관리자 *************");
		System.out.println("********3. 출고 관리자 *************");
		System.out.print(">  ");
		switch (sc.nextInt()) {
		case 1:
			lm=LibraryManagement.getInstance();
			break;
		case 2:
			lm=Buyer.getInstance();
			break;
		case 3:
			lm=Seller.getInstance();
			break;
		default :
			selectManager();
			break;
		}
		showMain();
	}
	
	public void showMain(){
		Scanner sc = new Scanner(System.in);
		int select = 0;
		int breakPoint = 0;
		
		while (breakPoint == 0) {
			System.out.println("******** 서        점 *************");
			System.out.println("********1. 도서등록 *************");
			System.out.println("********2. 도서삭제 *************");
			System.out.println("********3. 도서수정 *************");
			System.out.println("********4. 도서입고 *************");
			System.out.println("********5. 도서출고 *************");
			System.out.println("********6. 도서확인 *************");
			System.out.println("********7. 관리자 변경 *************");
			System.out.println("********8. 현재 자본금 확인 *************");
			System.out.println("********0. 종    료 *************");
			System.out.print(">  ");
			select = sc.nextInt();
			switch (select) {
			case 1:
				add();
				break;
			case 2:
				remove();
				break;
			case 3:
				update();
				break;
			case 4:
				buy();
				break;
			case 5:
				sell();
				break;
			case 6:
				view();
				break;
			case 7:
				selectManager();
				break;
			case 8:
				showStock();
				break;
			case 0:
				breakPoint++;
				break;
			}
		}
		System.out.println("안녕히 가세요~!");
	}
	
	private void showStock() {
		System.out.println("현재 자본 금액은 "+Constants.capitalStock +"원 입니다.");
	}

	public void add(){
		if(!(lm instanceof LibraryManagement)){
			System.out.println("권한이 없습니다.");
			return;
		}
		Scanner sc = new Scanner(System.in);
		Book book = null;
		Class clazz = null;
		int select = 0;

		System.out.println("******** 도 서 등 록 *************");
		System.out.println("********1. 잡     지  *************");
		System.out.println("********2. 교     육  *************");
		System.out.println("********3. 일     반 *************");
		System.out.println("********0. 취     소 *************");
		System.out.print(">  ");
		select = sc.nextInt();
		
		switch (select) {
		case 1:
			book = new Magazine();
			clazz = Magazine.class;
			break;
		case 2:
			book = new Education();
			clazz = Education.class;
			break;
		case 3:
			book = new Book();
			clazz = Book.class;
			break;
		case 0:
			break;
		}
		
		try {
			regist(clazz);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void regist(Class target) throws InstantiationException, IllegalAccessException{
		Scanner sc = new Scanner(System.in);
		Class clazz = target;
		Object obj = clazz.newInstance();
		String data = "";
		Method[] ocMethods = clazz.getMethods();
		for(Method m : ocMethods){
			try {
				if(m.getName().startsWith("set")){
					System.out.println(m.getName().substring(3)+" : ");
					data = sc.nextLine();
					if("int".equals(m.getParameterTypes()[0].toString())) m.invoke(obj, Integer.parseInt(data));
					else m.invoke(obj, data);
				}
			} catch (Exception e) {
			}
		}
		lm.add((Book)obj);
	}

	public void view() {
		Scanner sc = new Scanner(System.in);
		int select = 0;

		System.out.println("******** 도 서 보 기 *************");
		System.out.println("********1. 모 두 출 력  *************");
		System.out.println("********2. 종류별 출력 *************");
		System.out.println("********3. 물품별 출력  *************");
		System.out.println("********4. 취     소 *************");
		System.out.print(">  ");
		select = sc.nextInt();
		
		switch (select) {
		case 1:
			lm.allList();
			break;
			
		case 2:
			System.out.println("****1.잡지  2.교육  3.일반*****");
			System.out.print(">  ");
			select = sc.nextInt();
			switch(select){
			case 1:
				lm.magazineList();
				break;
			case 2:
				lm.educationList();
				break;
			case 3:
				lm.bookList();
				break;
			}
			break;
			
		case 3:
			sc.nextLine();
			System.out.println("ISBN을 입력해주세요 ");
			System.out.print(">  ");
			String isbn = sc.nextLine();
			Book book = lm.search(isbn);
			if(book ==null) return;
			String margin = String.format("%.2f", ((double)(book.getPrice()-book.getCost())/book.getCost())*100);
			System.out.println("["+book.getTitle()+"]의 원가 ["+book.getCost()+"원], 마진율 : ["+margin+"%]");	
			System.out.println("["+book.getTitle()+"]의 재고량 ["+book.getQuantity()+"권], 총 금액 : ["+book.getAmount()+"원]");	
			break;
		case 4:
			break;
		}
	}

	public void remove() {
		if(!(lm instanceof LibraryManagement)){
			System.out.println("권한이 없습니다.");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("ISBN을 입력해주세요 ");
		System.out.print(">  ");
		String isbn = sc.nextLine();
		lm.remove(isbn);
	}

	public void update() {
		if(!(lm instanceof LibraryManagement)){
			System.out.println("권한이 없습니다.");
			return;
		}
		List<Book> books = lm.getList();
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 ISBN을 적어주세요 >> ");
		String isbn = sc.nextLine();
		int index = 0;
		for(Book b: books){
			if(b.getIsbn().equals(isbn)){
				Class clazz = Book.class;
				String data = "";
				Method[] ocMethods = clazz.getDeclaredMethods();
				System.out.println(b);
				for(Method m : ocMethods){
					try {
						if(m.getName().startsWith("set") && !m.getName().equals("setIsbn") ){
							System.out.println(m.getName().substring(3)+" : ");
							data = sc.nextLine();
							if("int".equals(m.getParameterTypes()[0].toString())) m.invoke(b, Integer.parseInt(data));
							else m.invoke(b, data);
						}
					} catch (Exception e) {
					}
				}
				books.set(index, b);
				break;
			}
			index++;
		}
	}

	public void buy() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입고할 ISBN > ");
		String isbn = sc.nextLine();
		System.out.print("입고량(권 수) > ");
		int quantity = sc.nextInt();
		lm.buy(isbn, quantity);
	}
	
	public void sell() {
		Scanner sc = new Scanner(System.in);
		System.out.print("출고할 ISBN > ");
		String isbn = sc.nextLine();
		System.out.print("출고량(권 수) > ");
		int quantity = sc.nextInt();
		lm.sell(isbn, quantity);
	}
}
