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

			mainView.welcome();
			poemView.getPoems();
			try {
				login = mainView.loginMenu(scanner);
				if (login == 0 || login > 3) {
					throw new Exception();
				}
				switch (login) {
				case 1:
					try {
						joinController.join(scanner);
					} catch (Exception e1) {
						System.out.println("\n\t       이미 존재하는 아이디입니다. 다른 아이디를 입력해 주세요.");
					}
					continue;
				case 2:
					vo = signController.signIn(scanner);
					while (vo == null) {
						vo = signController.signIn(scanner);
					}
					break;
				case 3: // 프로그램 종료 빠져나가기.
					System.out.println("\n\t\t\t      프로그램을 종료합니다.");
					System.out.println("\n\t\t\t        다음에 또 만나요!\n");
					loginRun = false;
					mainRun = false;
					break;
				}

			} catch (Exception e) {
				System.out.println("\n\t\t\t\t 잘못된 입력입니다.");
				continue;
			}

			while (mainRun) {
				try {
					mainView.welcome();
					int menu = mainView.mainMenu(scanner);
					switch (menu) {
					case 1:// 이번 보름 챌린지
						do {

							BookVO nowBook = bookController.getNowChallenge("0003");
							bookView.getNowChallenge(nowBook);

							challenger = dao.getChallenger("0003");
							System.out.println("\t\t\t\t    챌린저: " + challenger + "명");
							System.out.println();
							try {
								if (challController.getStatus(session).equals("y")) {
									goal = challController.getGoal(session);
									if (goal == 100) {
										System.out.println("\t\t\t        달성률: ◼️◼️◼️◼️◼️  " + goal + " %");
									} else if (goal >= 80) {
										System.out.println("\t\t\t        달성률: ◼️◼️◼️◼️◻️  " + goal + " %");
									} else if (goal >= 60) {
										System.out.println("\t\t\t        달성률: ◼️◼️◼️◻️◻️  " + goal + " %");
									} else if (goal >= 40) {
										System.out.println("\t\t\t        달성률: ◼️◼️◻️◻️◻️  " + goal + " %");
									} else if (goal >= 20) {
										System.out.println("\t\t\t        달성률: ◼️◻️◻️◻️◻️  " + goal + " %");
									} else {
										System.out.println("\t\t\t        달성률: ◻️◻️◻️◻️◻️  " + goal + " %");
									}
								} else {
									System.out.println("\t\t\t        달성률: ◻️◻️◻️◻️◻️  " + goal + " %");
								}
							} catch (Exception e) {
								System.out.println("\t\t\t        달성률: ◻️◻️◻️◻️◻️  -- %");
							}

							int menu2 = mainView.startChallengeMenu(scanner);
							switch (menu2) {
							case 1: // 챌린지 시작
								try {
									ChallengeVO iMember = challengeView.insertChallengeStatus(scanner);
									if (iMember != null) {
										int insertStatus = challController.insertChallengeStatus(iMember);
										challengeView.insertStatusResult(insertStatus);
										continue;
									} else {
										System.out.println("\n\t\t   현재 " + challenger + "명의 챌린저가 도전 중입니다. 함께해 주세요!");
										continue;
									}

								} catch (java.sql.SQLIntegrityConstraintViolationException e) {
									System.out.println("\n\t\t\t\t이미 진행 중입니다.");
									continue;
								}
							case 2: // 페이지 입력
								try {
									if (challController.getStatus(session).equals("y")) {
										ChallengeVO iPage = challengeView.updateGoal(scanner);
										int updateGoal = challController.updateGoal(iPage);
										challengeView.updateGoalResult(updateGoal);
										continue;

									}
								} catch (NumberFormatException e) {
									System.out.println("\n\t\t       범위 밖의 숫자입니다. 다시 입력해 주세요.");
									continue;
								} catch (Exception e) {
									System.out.println("\n\t\t\t\t   .　｡・｡/) /)｡・｡");
									System.out.println("\t\t\t\t   ｡ﾟ 　( ﾟ´Д｀)　 ﾟ｡");
									System.out.println("\t\t\t\t   　　o( U U");
									System.out.println("\t\t\t\t  　 　 'ｰ'ｰ'");
									System.out.println("\n\t\t\t     먼저 챌린지를 시작해 주세요.");
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
							try {

								if (challController.getGoal(session) == 100) {
									ReviewVO iReview = reviewView.inputReview(scanner);
									if (iReview != null) {
										int insertReview = reviewController.insertReview(iReview);
										reviewView.inputResult(insertReview);
									}
								}
							} catch (Exception e) {
								System.out.println("\n\t\t\t챌린지 달성 후 작성이 가능합니다.");
								continue;

							}
						case 2:
							continue;
						}

					case 4: // 마이페이지
						System.out.println(
								"\n──────────────────────────────────────────────────────────────────────────────────────");
						System.out.println("\n\n\t\t\t    📌" + vo.getId() + "님의 챌린지 기록📌\n\n");

						try {
							List<BookVO> historys = bookController.getHistory(session.getId());
							bookView.getHistory(historys);
							System.out.print(challController.getGoal(session) + " %\n\n");

						} catch (Exception e) {
							System.out.println("\n\n\t\t\t       챌린지 기록이 없습니다.\n\n");
							continue;
						}

						int menu5 = mainView.toMainMenu(scanner);
						switch (menu5) {
						case 1:
							continue;

						default:
							continue;
						}

					case 5: // 로그아웃
						System.out.println("\n\t\t\t         로그아웃 되었습니다.");
						mainView.welcome();
						poemView.getPoems();
						int menu6 = mainView.loginMenu(scanner);
						switch (menu6) {
						case 5:
							mainView.welcome();
							poemView.getPoems();
							mainView.loginMenu(scanner);
							break;
						case 3:
							System.out.println("\n\t\t\t      프로그램을 종료합니다.");
							System.out.println("\n\t\t\t        다음에 또 만나요!\n");
							loginRun = false;
							mainRun = false;
							break;

						default:
							break;
						}

					default:
						continue;

					} // switch menu
				} catch (Exception e) {
					System.out.println("\n\t\t\t\t 잘못된 입력입니다.");
					continue;
				} // while(mainRun)
			}
		}

		// while(login run)
	} // process
} // class
