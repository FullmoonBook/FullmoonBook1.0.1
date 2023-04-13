package fullmoonbook.challenge;

import java.util.Scanner;

import fullmoonbook.challenge.ChallengeController;
import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.challenge.ChallengeView;

public class FrontController {
	
	private static FrontController instance = new FrontController(); //FrontController 싱글톤 생성
	private FrontController() {
	}
	public static FrontController getInstance() {
		return instance;
	}
	
	private ChallengeController controller = ChallengeController.getInstance(); //controller 호출
	private ChallengeView view = ChallengeView.getInstance();//View 호출
	private Scanner scanner = new Scanner(System.in); //Scanner 생성을 여기서 함.
	ChallengeVO vo = new ChallengeVO();//VO 객체 생성
	
	public void process() throws Exception {
		view.getChallenge(vo);
		
		while (true) {
			view.getThisChallenge();
			
		}
		
	}
	
//	private ChallengeView view = new ChallengeView();
//	private ChallengeController controller = ChallengeController.getInstance();
//	ChallengeVO book = controller.getChallenge("0003");

	
	
//	view.getChallenge(book);
}
