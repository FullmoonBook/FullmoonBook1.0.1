package fullmoonbook.book;

import java.util.Scanner;

import fullmoonbook.challenge.ChallengeController;
import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.challenge.ChallengeView;
import fullmoonbook.common.MainView;
import fullmoonbook.join.JoinController;
import fullmoonbook.join.JoinView;
import fullmoonbook.poem.PoemController;
import fullmoonbook.poem.PoemView;
import fullmoonbook.review.ReviewController;
import fullmoonbook.sign.SignController;
import fullmoonbook.sign.SignView;

public class FrontController {
	private static FrontController instance = new FrontController(); // FrontController 싱글톤 생성

	private BookController bookController = BookController.getInstance();
	private ChallengeController controller = ChallengeController.getInstance(); // controller 호출
	private JoinController joinController = JoinController.getInstance();
	private PoemController poemController = PoemController.getInstance();
	private ReviewController reviewController = ReviewController.getInstance();
	private SignController signController = SignController.getInstance();

	private BookView bookView = BookView.getInstance();
	private ChallengeView view = ChallengeView.getInstance();// View 호출
	private MainView mainView = MainView.getInstance();
	private JoinView joinView = JoinView.getInstance();
	private PoemView poemView = PoemView.getInstance();
//	private ReviewView reviewView = ReviewView.getInstance();
	private SignView signView = SignView.getInstance();

	private Scanner scanner = new Scanner(System.in); // Scanner 생성을 여기서 함.

	// ChallengeVO vo = new ChallengeVO();//VO 객체 생성
	public boolean run = true;
	int login = 0;

	public FrontController() {
	}

	public static FrontController getInstance() {
		return instance;
	}

	public void process() throws Exception {
//		view.getChallenge(vo);
//		while (true) {
//			view.getThisChallenge();
//			//			private ChallengeView view = new ChallengeView();
//			//			private ChallengeController controller = ChallengeController.getInstance();
//			//			ChallengeVO book = controller.getChallenge("0003");
//
//			//			view.getChallenge(book);
//		}
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

		// while (run) {
		// int menu = mainView.mainManu(scanner);
		// switch (menu) {
		// case 1:
		// BookVO nowBook = bookController.getNowChallenge("0003");
		// bookView.getNowChallenge(nowBook);
		// break;
		// case 2:
		// BookVO nextBook = bookController.getNextChallenge("0004");
		// bookView.getNextChallenge(nextBook);
		// break;
		// case 3:
		// mainView.welcome();
		// break;
		// case 4:
		// System.out.println("로그아웃 되었습니다");
		// mainView.welcome();
		// break;
		// case 5:
		// System.out.println("프로그램을 종료합니다.");
		// run = false;
		//
		// default:
		// break;
		// }
	}
}
