package fullmoonbook.book;

import java.util.Scanner;

public class BookView {
	private static BookView instance = new BookView();

	private BookView() {
	}

	public static BookView getInstance() {
		return instance;
	}

	public void welcome() {
		System.out.println("\t  ₍ᐢ｡ ˬ ｡ᐢ₎\n\t보름 한 책");
		

	}
	public void login() {
		System.out.println("회원가입");
		System.out.println("로그인");
	}
	public int mainManu(Scanner scanner) {
		System.out.println("");
		
		System.out.println("1. 현재 챌린지 2. 다음 챌린지 \n3. 이전 페이지 4. 로그아웃");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());
		
		
	}
	public void getNowChallenge(BookVO vo) {
		System.out.println("─────────────────────────────────────");
		System.out.println("\t  이번 보름 챌린지");
		System.out.println("─────────────────────────────────────");
		System.out.println(vo.printBook(false));
	}
	public void getNextChallenge(BookVO vo) {
		System.out.println("─────────────────────────────────────");
		System.out.println("\t  다음 보름 챌린지");
		System.out.println("─────────────────────────────────────");
		System.out.println(vo.printBook(true));
	}
	

	
		
}