package fullmoonbook.book;

import java.util.Scanner;

public class BookView {
	private static BookView instance = new BookView();

	private BookView() {
	}

	public static BookView getInstance() {
		return instance;
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