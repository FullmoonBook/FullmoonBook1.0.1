package fullmoonbook.book;

import java.util.List;
import java.util.Scanner;

public class BookView {
//	public static void main(String[] args) {
//		BookDAO dao = new BookDAO();
//		new BookVO()
//		
//	}
	private static BookView instance = new BookView();

	private BookView() {
	}

	public static BookView getInstance() {
		return instance;
	}

	public void getNowChallenge(BookVO vo) {
		System.out.println("\n──────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("\t\t\t\t  이번 보름 챌린지");
		System.out.println(vo.printBook(false));
		System.out.println();
	}

	public void getNextChallenge(BookVO vo) {
		System.out.println("\n──────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("\n");
		System.out.println("\t\t\t\t  다음 보름 챌린지");
		System.out.println(vo.printBook(true));
		System.out.println();
	}

	public void getChallenge(BookVO vo) {
		System.out.println("\n──────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("\t\t\t\t  현재 챌린지");
		System.out.println(vo.printA());
		System.out.println();
	}

	public void getHistory(List<BookVO> historys) {
		for (BookVO history : historys) {
			System.out.println(history);
		}
	}

}