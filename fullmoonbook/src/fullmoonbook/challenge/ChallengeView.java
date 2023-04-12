package fullmoonbook.challenge;

import java.util.Scanner;

public class ChallengeView {
	public static void main(String[] args) {
	
	}
	
	private static ChallengeView instance = new ChallengeView();//싱글톤(객체 1개만 생성)
	public ChallengeView() {
	}
	public static ChallengeView getInstance() {//getInstance로 호출.
		return instance;
	}
	//Scanner scanner = new Scanner(System.in);//이거 안써도 되나요??? (FrontController에서 쓴다!)
	//이거 왜 private으로 해야 함??(아래꺼)
	
	private ChallengeController controller = ChallengeController.getInstance();
	
	public void getChallenge(ChallengeVO vo) throws Exception {
		System.out.println(vo.printNA());
	} 
	
	public void getThisChallenge() throws Exception {
		System.out.println("<이번 보름 챌린지>");
		System.out.println(controller.getChallenge("0003"));
	}

	
	public ChallengeVO startChallenge(Scanner scanner) {
		System.out.println("도전하겠습니까? (Y/N)");
		String status = scanner.nextLine();
		return new ChallengeVO(status);
	}
	
}
