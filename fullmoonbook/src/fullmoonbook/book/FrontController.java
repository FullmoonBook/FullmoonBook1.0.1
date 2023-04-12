package fullmoonbook.book;

import java.util.Scanner;

import fullmoonbook.book.BookController;
import fullmoonbook.book.BookVO;
import fullmoonbook.book.BookView;
import fullmoonbook.poem.PoemController;
import fullmoonbook.poem.PoemView;

public class FrontController {
	private static FrontController instance = new FrontController();


	FrontController() {
	}

	public static FrontController getInstance() {
		return instance;
	}

	private BookController bookController = BookController.getInstance();
	private PoemController poemController = PoemController.getInstance();
	
	private BookView bookView = BookView.getInstance();
	private PoemView poemView = PoemView.getIstance();
	private Scanner scanner = new Scanner(System.in);
	public boolean run = true;

	public void process() throws Exception {
		bookView.welcome();
		poemView.getPoems();
		while (run) {
			int menu = bookView.mainManu(scanner);
			switch (menu) {
			case 1:
				BookVO nowBook = bookController.getNowChallenge("0003");
				bookView.getNowChallenge(nowBook);
				break;
			case 2:
				BookVO nextBook = bookController.getNextChallenge("0004");
				bookView.getNextChallenge(nextBook);
				break;
			case 3:
				bookView.welcome();
				break;
			case 4:
				System.out.println("로그아웃 되었습니다");
				bookView.welcome();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				run = false;

			default:
				break;
			}
		}
	}
}
