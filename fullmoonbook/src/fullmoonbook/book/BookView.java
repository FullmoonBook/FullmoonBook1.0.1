package fullmoonbook.book;

import java.util.List;
import java.util.Scanner;

import fullmoonbook.common.BookApplication;

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

	public void getHistory(List<BookVO> historys) {
		if (historys != null) {
			for (BookVO history : historys) {
				System.out.println("\n\t\t도서명 \t\t챌린지 기간 \t\t  달성률");
				System.out.print(history.printHistory(historys));
			}
		} else if (!(BookApplication.challengeGetSession().getStatus().equals("y"))) {
			System.out.println("챌린지 기록이 없습니다.");
		}
	}
}
