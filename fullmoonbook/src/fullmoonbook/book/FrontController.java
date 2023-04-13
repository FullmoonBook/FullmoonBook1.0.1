package fullmoonbook.book;

import java.util.Scanner;

import fullmoonbook.book.BookController;
import fullmoonbook.book.BookVO;
import fullmoonbook.book.BookView;
import fullmoonbook.common.HomeMenu;
import fullmoonbook.common.MainView;
import fullmoonbook.join.JoinController;
import fullmoonbook.join.JoinView;
import fullmoonbook.poem.PoemController;
import fullmoonbook.poem.PoemView;
import fullmoonbook.sign.SignController;

public class FrontController {
	private static FrontController instance = new FrontController();

	public FrontController() {
	}

	public static FrontController getInstance() {
		return instance;
	}

	private BookController bookController = BookController.getInstance();
	private PoemController poemController = PoemController.getInstance();
	private JoinController joinController = JoinController.getInstance();
	private SignController signController = SignController.getInstance();

	private MainView mainView = MainView.getInstance();
	private BookView bookView = BookView.getInstance();
	private PoemView poemView = PoemView.getIstance();
//	private JoinView joinView = JoinView.getIstance();

	private Scanner scanner = new Scanner(System.in);
	public boolean run = true;
	int login = 0;

	public void process() throws Exception {
		mainView.welcome();
		poemView.getPoems();
		login = mainView.login(scanner);

		switch (login) {
		case 1:
			joinController.join(scanner);
			mainView.welcome();
			login = mainView.login(scanner);
			
		case 2:
			signController.signIn(scanner);
			login = 3;
			break;
		case 3:
			mainView.mainManu(scanner);
			break;
			

		}

//		while (run) {
//			int menu = mainView.mainManu(scanner);
//			switch (menu) {
//			case 1:
//				BookVO nowBook = bookController.getNowChallenge("0003");
//				bookView.getNowChallenge(nowBook);
//				break;
//			case 2:
//				BookVO nextBook = bookController.getNextChallenge("0004");
//				bookView.getNextChallenge(nextBook);
//				break;
//			case 3:
//				mainView.welcome();
//				break;
//			case 4:
//				System.out.println("로그아웃 되었습니다");
//				mainView.welcome();
//				break;
//			case 5:
//				System.out.println("프로그램을 종료합니다.");
//				run = false;
//
//			default:
//				break;
//			}
	}
}
