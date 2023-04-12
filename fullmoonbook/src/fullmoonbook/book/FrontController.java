package fullmoonbook.book;

import java.util.Scanner;

import fullmoonbook.book.BookController;
import fullmoonbook.book.BookVO;
import fullmoonbook.book.BookView;

public class FrontController {
	private static FrontController instance = new FrontController();

	FrontController() {
	}

	public static FrontController getInstance() {
		return instance;
	}

	private BookController controller = BookController.getInstance();
	private BookView view = BookView.getInstance();
	private Scanner scanner = new Scanner(System.in);
	public boolean run = true;

	public void process() throws Exception {
		view.welcome();
		while (run) {
			int menu = view.mainManu(scanner);
			switch (menu) {
			case 1:
				BookVO nowBook = controller.getNowChallenge("0003");
				view.getNowChallenge(nowBook);
				break;
			case 2:
				BookVO nextBook = controller.getNextChallenge("0004");
				view.getNextChallenge(nextBook);
				break;
			case 3:
				view.welcome();
				break;
			case 4:
				System.out.println("로그아웃 되었습니다");
				view.welcome();
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
