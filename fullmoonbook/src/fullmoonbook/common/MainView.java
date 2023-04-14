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

	public int loginMenu(Scanner scanner) {
		System.out.println("");
		System.out.println("\t1. 회원가입");
		System.out.println("\t2. 로그인");
		System.out.println("\t3. 프로그램 종료");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());

	}

	public int mainMenu(Scanner scanner) {
		System.out.println("");
		System.out.println("1. 현재 챌린지 2. 다음 챌린지 3. 마이페이지 4. 로그아웃");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());
	}

	public int nowBookMenu(Scanner scanner) {
		System.out.println("");
		System.out.println("1. 현재 챌린지 2. 도서 리뷰 3. 메인 페이지 ");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());
	}
    //달성률이 100이 아닐 때
	public int toMainMenu(Scanner scanner) {
		System.out.println("");
		System.out.println("1. 메인 페이지");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());
	}
	public int startChallengeMenu(Scanner scanner) {
		System.out.println("");
		System.out.println("1. 챌린지 시작");
		System.out.println("2. 메인 페이지");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());
	}
    //달성률이 100일 때
	public int reviewMenu(Scanner scanner) {
		System.out.println("");
		System.out.println("1. 리뷰 작성 2. 메인 페이지 ");
		System.out.println("");
		System.out.print("메뉴를 선택하세요> ");
		return Integer.parseInt(scanner.nextLine());

	}
}
