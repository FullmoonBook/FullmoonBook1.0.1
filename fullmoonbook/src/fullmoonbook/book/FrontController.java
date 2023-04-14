package fullmoonbook.book;

import java.util.List;
import java.util.Scanner;

import fullmoonbook.challenge.ChallengeController;
import fullmoonbook.challenge.ChallengeDAO;
import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.challenge.ChallengeView;
import fullmoonbook.common.BookApplication;
import fullmoonbook.common.MainView;
import fullmoonbook.join.JoinController;
import fullmoonbook.join.JoinView;
import fullmoonbook.join.MemberVO;
import fullmoonbook.poem.PoemController;
import fullmoonbook.poem.PoemView;
import fullmoonbook.review.ReviewController;
import fullmoonbook.review.ReviewDAO;
import fullmoonbook.review.ReviewVO;
import fullmoonbook.review.ReviewView;
import fullmoonbook.sign.SignController;
import fullmoonbook.sign.SignView;

public class FrontController {
	private static FrontController instance = new FrontController(); // FrontController 싱글톤 생성
	private ChallengeVO session = BookApplication.challengeGetSession();

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
	private ReviewView reviewView = ReviewView.getInstance();
	private SignView signView = SignView.getInstance();

	private Scanner scanner = new Scanner(System.in);
	public boolean loginRun = true;
	public boolean mainRun = true;
	int login = 0;
	int goal = 0;
	MemberVO vo = null;
	ChallengeVO challVo = new ChallengeVO();
	int challenger = 0;
	// ChallengeVO challengeVO = null;

	public void process() throws Exception {
		while (loginRun) {
			do {
				mainView.welcome();
				poemView.getPoems();
				try {
					login = mainView.loginMenu(scanner);
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
				}
			} while (!(login == 1 || login == 2));

			switch (login) {
			case 1:
				joinController.join(scanner);
			case 2:
				vo = signController.signIn(scanner);
				System.out.println(challController.getStatus(session));
				while (vo == null) {
					signController.signIn(scanner);
					break;
				}
			case 3: // 프로그램 종료 빠져나가기.
				loginRun = false;
				break;
			}
			while (mainRun) {
				mainView.welcome();
				
				int menu = mainView.mainMenu(scanner);
				switch (menu) {
				case 1://현재 챌린지 
					
					int menu2 = mainView.nowBookMenu(scanner);
					switch (menu2) {
					case 1: //현재 챌린지 정보
						BookVO nowBook = bookController.getNowChallenge("0003");
						bookView.getNowChallenge(nowBook);
						ChallengeDAO dao = ChallengeDAO.getInstance();
						challenger = dao.getChallenger("0003");
						System.out.println("\t    챌린저: " + challenger + "명");
						System.out.println();
						goal = challController.getGoal(session);
						if (goal == 100) {
							System.out.println("         달성률: ■■■■■ " + goal + " %");
						} else if (goal >= 80) {
							System.out.println("         달성률: ■■■■□ " + goal + " %");

						} else if (goal >= 60) {
							System.out.println("         달성률: ■■■□□ " + goal + " %");

						} else if (goal >= 40) {
							System.out.println("         달성률: ■■□□□ " + goal + " %");

						} else if (goal >= 20) {
							System.out.println("         달성률: ■□□□□ " + goal + " %");

						} else {
							System.out.println("         달성률: □□□□□ " + goal + " %");
						}
						
						int menu3 = mainView.startChallengeMenu(scanner);
						switch (menu3) {
						case 1: // 챌린지 시작
							try {
								ChallengeVO iMember = challengeView.insertChallengeStatus(scanner);
								if (iMember != null) {
									int insertStatus = challController.insertChallengeStatus(iMember);
									challengeView.insertStatusResult(insertStatus);
								} else {
									System.out.println("현재 " + challenger + "명의 챌린저가 도전 중입니다. 함께해 주세요");

								}

							} catch (Exception e) {
								System.out.println("이미 진행 중입니다.");
							}
							break;

						case 2: // 페이지 입력
							if (challController.getStatus(session).equals("y")) {
								ChallengeVO iPage = challengeView.updateGoal(scanner);
								challController.updateGoal(iPage);
							} else {
								System.out.println("먼저 챌린지를 시작해 주세요.");
								break;
							}
							break;
						}

//						if (menu3 == 1) {
//							break;
//						}
						break;

					case 2: // 도서 리뷰
						if (goal == 100) {
							List<ReviewVO> reivews = reviewController.getReviews();
							reviewView.getReviews(reivews);
							ReviewVO iReview = reviewView.inputReview(scanner);
							if (iReview != null) {
								int insertReview = reviewController.insertReview(iReview);
								reviewView.inputResult(insertReview);
							} else {
								System.out.println("완독하고 오세요...");
							}
							int menu4 = mainView.reviewMenu(scanner);
							if (menu4 == 2) {
								break;
							} else if (BookApplication.challengeGetSession().getGoal() == 100) {
							} else {
								System.out.println("달성률 채우기");
								break;
							}
						}
					case 3:
						break;

					}
					break;
				case 2: // 다음 챌린지
					BookVO nextBook = bookController.getNextChallenge("0004");
					bookView.getNextChallenge(nextBook);
					int menu5 = mainView.toMainMenu(scanner);
					if (menu5 == 1) {
						break;
					}
					break;
				case 3: // 마이페이지
					System.out.println();
					int menu6 = mainView.toMainMenu(scanner);
					if (menu6 == 1) {
						break;
					}
					break;
				case 4: // 로그아웃
					System.out.println("로그아웃 되었습니다");
					mainRun = false;
					break;

				default:
					break;
				}
			}
		}
	}
}
//	//	joinController.join(scanner);
//
//
//		case 2:
//			MemberVO vo = signController.signIn(scanner);
//
//			List<ReviewVO> reivews = reviewController.getReviews();
//			reviewView.getReviews(reivews);
//
//		}
//	}
//}

//			MemberVO vo = signController.signIn(scanner);
//
//			ChallengeVO iMember = challengeView.insertChallengeStatus(scanner);
//			if (iMember != null) {
//				int insertStatus = challController.insertChallengeStatus(iMember);
//				challengeView.insertStatusResult(insertStatus);
//			} else if (iMember == null) {
//				ChallengeDAO dao = new ChallengeDAO();
//				int challenger = dao.getChallenger("0003");
//				System.out.println("현재 " + challenger + "명의 챌린저가 도전 중입니다. 함께해 주세요");
//				// 다시 이전 페이지 호출s
//
//			}
//
