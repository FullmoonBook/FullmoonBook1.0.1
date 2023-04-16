package fullmoonbook.challenge;

import java.util.Scanner;

import fullmoonbook.common.BookApplication;
import fullmoonbook.join.MemberVO;

public class ChallengeView {
	public static final Scanner SCANNER = new Scanner(System.in);


	private static ChallengeView instance = new ChallengeView();// 싱글톤(객체 1개만 생성)

	public ChallengeView() {
	}

	public static ChallengeView getInstance() {// getInstance로 호출.
		return instance;
	}
	// Scanner scanner = new Scanner(System.in);//이거 안써도 되나요??? (FrontController에서
	// 쓴다!)
	// 이거 왜 private으로 해야 함??(아래꺼)

	private ChallengeController controller = ChallengeController.getInstance(); // controller 호출

	public void getChallenge(ChallengeVO vo) throws Exception {
		System.out.println(vo.printNA());
	}

	public void getThisChallenge() throws Exception {
		System.out.println("\t  <이번 보름 챌린지>");
	}

	public void getThisBookNo() throws Exception {
		System.out.println(controller.getChallenge("0003"));
	}

	public ChallengeVO insertChallengeStatus(Scanner scanner) throws Exception{
		System.out.print("\n   🌒 도전하시겠습니까? (Y/N) ▹ ");
		String status = scanner.nextLine();
		if (status.equals("y")) {
			return new ChallengeVO(status);
		}
		return null;
	}

	public void insertStatusResult(int count) {
		if (count > 0) {
			System.out.println("\n\t\t\t    당신의 도전을 응원합니다!");
		} else {
			System.out.println("");
		}

	}

	public ChallengeVO updateGoal(Scanner scanner) throws Exception  {
		System.out.print("\n   🌒 현재 읽은 페이지를 입력해 주세요(1~165쪽) ▹ ");
		int nowPage = Integer.parseInt(scanner.nextLine());
		if (nowPage > 0 && nowPage <= 165) {
			return new ChallengeVO(nowPage);
		} else {
			throw new NullPointerException();//null로 넣으면 nullpointer 오류
		}
	}

	public void updateGoalResult(int count) {
		if (count > 0) {
			System.out.println("\n\t\t\t 페이지가 정상적으로 입력되었습니다.");
			System.out.println("\n\t\t\t\t   ⚑ " + BookApplication.challengeGetSession().getNowPage() + " / 165쪽");
		} else {
			System.out.println("\n\t\t\t  정상적으로 입력되지 않았습니다.");
		}
	}
	public ChallengeVO getStatus(ChallengeVO vo) throws Exception {
		return new ChallengeVO(vo.getStatus());
	}
	public static String inputMenu() {
		return SCANNER.nextLine();
		
	}


}
