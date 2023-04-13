package fullmoonbook.common;

import java.util.Scanner;

public class MainView {
	private static MainView instance = new MainView();

	private MainView() {
	}

	public static MainView getInstance() {
		return instance;
	}

	public void welcome() {
		System.out.println("\t     ₍ᐢ｡ ˬ ｡ᐢ₎\n\t   보름 한 책");
	}

	public int login(Scanner scanner) {
		System.out.println("");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());

	}

	public int mainManu(Scanner scanner) {
		System.out.println("");
		System.out.println("1. 현재 챌린지 2. 다음 챌린지 3. 로그아웃");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());
	}

	public int nowBookManu(Scanner scanner) {
		System.out.println("");
		System.out.println("1. 현재 챌린지 2. 도서 리뷰 3. 이전 페이지");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());
	}

	public int nextBookManu(Scanner scanner) {
		System.out.println("");
		System.out.println("1. 현재 챌린지 2. 도서 리뷰 3. 이전 페이지");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());
	}
}
