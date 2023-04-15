package fullmoonbook.common;

import java.util.List;
import java.util.Scanner;

import fullmoonbook.book.BookController;
import fullmoonbook.book.BookVO;
import fullmoonbook.book.BookView;
import fullmoonbook.challenge.ChallengeController;
import fullmoonbook.challenge.ChallengeDAO;
import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.challenge.ChallengeView;
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
	ChallengeDAO dao = ChallengeDAO.getInstance(); // <<<<<<<<<<<<<<<<<<<<

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
	public boolean nowRun = true;

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
				case 1:// 이번 보름 챌린지
					do {

						BookVO nowBook = bookController.getNowChallenge("0003");
						bookView.getNowChallenge(nowBook);

						challenger = dao.getChallenger("0003");
						System.out.println("\t    챌린저: " + challenger + "명");
						System.out.println();
						try {
							if (challController.getStatus(session).equals("y")) {
								goal = challController.getGoal(session);
								if (goal == 100) {
									System.out.println("         달성률: 📘📘📘📘📘 " + goal + " %");
								} else if (goal >= 80) {
									System.out.println("         달성률: 📘📘📘📘📕 " + goal + " %");

								} else if (goal >= 60) {
									System.out.println("         달성률: 📘📘📘📕📕 " + goal + " %");

								} else if (goal >= 40) {
									System.out.println("         달성률: 📘📘📕📕📕 " + goal + " %");

								} else if (goal >= 20) {
									System.out.println("         달성률: 📘📕📕📕📕 " + goal + " %");

								} else {
									System.out.println("         달성률: 📕📕📕📕📕 " + goal + " %");
								}
							} else {

								System.out.println("         달성률: 📕📕📕📕📕 " + goal + " %");
							}

						} catch (Exception e) {
							System.out.println("         달성률: 📕📕📕📕📕  0 %");
						}

						int menu2 = mainView.startChallengeMenu(scanner);
						switch (menu2) {
						case 1: // 챌린지 시작
							try {
								ChallengeVO iMember = challengeView.insertChallengeStatus(scanner);
								if (iMember != null) {
									int insertStatus = challController.insertChallengeStatus(iMember);
									challengeView.insertStatusResult(insertStatus);
								} else {
									System.out.println("현재 " + challenger + "명의 챌린저가 도전 중입니다. 함께해 주세요!");
									continue;
								}

							} catch (Exception e) {
								System.out.println("이미 진행 중입니다.");
								continue;
							}
						case 2: // 페이지 입력
							try {
								if (challController.getStatus(session).equals("y")) {
									ChallengeVO iPage = challengeView.updateGoal(scanner);
									int updateGoal = challController.updateGoal(iPage);
									challengeView.updateGoalResult(updateGoal);
									continue;

								} else {
									System.out.println(".　｡・｡/) /)｡・｡");
									System.out.println("｡ﾟ 　( ﾟ´Д｀)　 ﾟ｡");
									System.out.println("　　o( U U");
									System.out.println("　　 'ｰ'ｰ'");
									System.out.println("먼저 챌린지를 시작해 주세요.");
									continue;
								}
							} catch (Exception e) {
								System.out.println(".　｡・｡/) /)｡・｡");
								System.out.println("｡ﾟ 　( ﾟ´Д｀)　 ﾟ｡");
								System.out.println("　　o( U U");
								System.out.println("　　 'ｰ'ｰ'");
								System.out.println("먼저 챌린지를 시작해 주세요.");
								continue;
							}

						case 3: // 메인 페이지로
							nowRun = false;
							break;

						default:
							continue;
						}
					} while (nowRun);
					break;

				case 2: // 다음 챌린지
					BookVO nextBook = bookController.getNextChallenge("0004");
					bookView.getNextChallenge(nextBook);
					int menu3 = mainView.toMainMenu(scanner);
					if (menu3 == 1) {
						continue;
					}

				case 3: // 후기
					List<ReviewVO> reivews = reviewController.getReviews();
					reviewView.getReviews(reivews);
					int menu4 = mainView.reviewMenu(scanner);
					switch (menu4) {
					case 1:
						if (BookApplication.challengeGetSession().getGoal() == 100) {
							ReviewVO iReview = reviewView.inputReview(scanner);
							if (iReview != null) {
								int insertReview = reviewController.insertReview(iReview);
								reviewView.inputResult(insertReview);
							}
						} else {
							System.out.println("챌린지 달성 후 작성이 가능합니다.");
						}
					case 2:
						continue;
					}

				case 4: // 마이페이지
					System.out.println();
					System.out.println();
					System.out.println("\t\t\t 📌" + vo.getId() + "님의 챌린지 기록📌");

//					try {
						List<BookVO> historys = bookController.getHistory(session.getId());
						bookView.getHistory(historys);

//					} catch (Exception e) {
//						System.out.println("챌린지 기록이 없습니다.");
//						continue;
//					}

//					System.out.println(dao.getChallenge("0003").getBookName() + challController.getGoal(session) + "%");
					int menu5 = mainView.toMainMenu(scanner);
					switch (menu5) {
					case 1:
						continue;

					default:
						continue;
					}

				case 5: // 로그아웃
					System.out.println("로그아웃 되었습니다.");
					int menu6 = mainView.toMainMenu(scanner);
					switch (menu6) {
					case 5:
						mainView.welcome();
						poemView.getPoems();
					    mainView.loginMenu(scanner);
					    break;

					default:
						break;
					}
					
				default:
					continue;

				} // switch menu
			} // while(mainRun)
		} // while(login run)
	} // process
} // class
