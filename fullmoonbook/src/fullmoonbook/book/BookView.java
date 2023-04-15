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
	public void getChallenge(BookVO vo) {
		System.out.println("─────────────────────────────────────");
		System.out.println("\t  현재 챌린지");
		System.out.println("─────────────────────────────────────");
		System.out.println(vo.printA());
	}
	public void getHistory (List<BookVO> historys) {
		System.out.println("챌린지 기록");
		for (BookVO history : historys) {
			System.out.println(history);
		}
	}
	
}