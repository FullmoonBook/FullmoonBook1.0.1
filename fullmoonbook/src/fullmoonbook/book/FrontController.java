package fullmoonbook.book;

import java.util.Scanner;

import fullmoonbook.challenge.ChallengeController;
import fullmoonbook.challenge.ChallengeDAO;
import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.challenge.ChallengeView;
import fullmoonbook.common.MainView;
import fullmoonbook.join.JoinController;
import fullmoonbook.join.JoinView;
import fullmoonbook.join.MemberVO;
import fullmoonbook.poem.PoemController;
import fullmoonbook.poem.PoemView;
import fullmoonbook.review.ReviewController;
import fullmoonbook.sign.SignController;
import fullmoonbook.sign.SignView;

public class FrontController {
	private static FrontController instance = new FrontController(); // FrontController 싱글톤 생성

	public FrontController() {
	}

	public static FrontController getInstance() {
		return instance;
	}

	private BookController bookController = BookController.getInstance();
	private ChallengeController challController = ChallengeController.getInstance(); // controller 호출
	private JoinController joinController = JoinController.getInstance();
	private PoemController poemController = PoemController.getInstance();
	private ReviewController reviewController = ReviewController.getInstance();
	private SignController signController = SignController.getInstance();

	private BookView bookView = BookView.getInstance();
	private ChallengeView challengeView = ChallengeView.getInstance();
	private MainView mainView = MainView.getInstance();
	private JoinView joinView = JoinView.getInstance();
	private PoemView poemView = PoemView.getInstance();
//	private ReviewView reviewView = ReviewView.getInstance();
	private SignView signView = SignView.getInstance();

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
			// mainView.login(scanner);
			break;

		case 2:
			MemberVO vo = signController.signIn(scanner);

			ChallengeVO iMember = challengeView.insertChallengeStatus(scanner);
			if (iMember != null) {
				int insertStatus = challController.insertChallengeStatus(iMember);
				challengeView.insertStatusResult(insertStatus);
			} else if (iMember == null) {
				ChallengeDAO dao = new ChallengeDAO();
				int challenger = dao.getChallenger("0003");
				System.out.println("현재 " + challenger + "명의 챌린저가 도전 중입니다. 함께해 주세요");
				// 다시 이전 페이지 호출

			}

			break;

		case 3:
			MemberVO vo1 = signController.signIn(scanner);
			ChallengeVO uGoal = challengeView.updateGoal(scanner);
			if (uGoal != null) {
				int updateGoal = challController.updateGoal(uGoal);
				challengeView.updateGoalResult(updateGoal);
			}
			
			
		case 4: 
			MemberVO vo2 = signController.signIn(scanner);
			ChallengeVO vo3 = new ChallengeVO();
			
			int goal = vo3.getGoal();
			if(goal > 80) {
				System.out.println("달성률: ■■■■□");
			}
			System.out.println("달성률: ■■■■□");



			
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
