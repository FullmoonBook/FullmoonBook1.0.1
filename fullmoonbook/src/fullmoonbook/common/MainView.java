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
		System.out.println("\n──────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("\t\t\t\t       /) /)");
		System.out.println("\t\t\t\t       (｡･-･)♥");
		System.out.println("\t\t\t\t   🥕보름 한 책🥕");
		System.out.println();
	}

	public int loginMenu(Scanner scanner) throws Exception {
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t          1. 회원가입");
		System.out.println("\t\t\t          2. 로그인");
		System.out.println("\t\t\t          3. 프로그램 종료");
		System.out.println("\n\n──────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("\n   🌒 메뉴를 선택하세요 ▹ ");
		return Integer.parseInt(scanner.nextLine());

	}

	public int mainMenu(Scanner scanner) {
		System.out.println("\n\n");
		System.out.println("\t\t\t       1. 이번 보름 챌린지");
		System.out.println("\t\t\t       2. 다음 보름 챌린지");
		System.out.println("\t\t\t       3. 이번 보름 책 후기");
		System.out.println("\t\t\t       4. 챌린지 기록");
		System.out.println("\t\t\t       5. 로그아웃");
		System.out.println("\n\n\n──────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("\n   🌒 메뉴를 선택하세요 ▹ ");
		return Integer.parseInt(scanner.nextLine());
	}

//	public int nowBookMenu(Scanner scanner) {
//		System.out.println("\n\n──────────────────────────────────────────────────────────────────────────────────────");
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("\t\t\t1. 챌린지 정보");
//		System.out.println("\t\t\t2. 도서 리뷰");
//		System.out.println("\t\t\t3. 메인 페이지");
//		System.out.println("\n──────────────────────────────────────────────────────────────────────────────────────");
//		System.out.print("\n메뉴를 선택하세요> ");
//		return Integer.parseInt(scanner.nextLine());
//	}

	// 달성률이 100이 아닐 때
	public int toMainMenu(Scanner scanner) {
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t\t  1. 메인 페이지");
		System.out.println("\n\n──────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("\n   🌒 메뉴를 선택하세요 ▹ ");
		return Integer.parseInt(scanner.nextLine());
	}

	public int startChallengeMenu(Scanner scanner) {
		System.out.println();
		System.out.println("\t\t\t\t   1. 챌린지 시작");
		System.out.println("\t\t\t\t   2. 페이지 입력");
		System.out.println("\t\t\t\t   3. 메인 페이지");
		System.out.println("\n──────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("\n   🌒 메뉴를 선택하세요 ▹ ");
		return Integer.parseInt(scanner.nextLine());
	}

	// 달성률이 100일 때
	public int reviewMenu(Scanner scanner) {
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t           1. 리뷰 작성");
		System.out.println("\t\t\t           2. 메인 페이지");
		System.out.println("\n\n──────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("\n   🌒 메뉴를 선택하세요 ▹ ");
		return Integer.parseInt(scanner.nextLine());
	}
}
