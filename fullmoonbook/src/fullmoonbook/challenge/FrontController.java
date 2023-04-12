package fullmoonbook;

import java.util.Scanner;

import fullmoonbook.challenge.ChallengeController;
import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.challenge.ChallengeView;

public class FrontController {
	
	private static FrontController instance = new FrontController();
	private FrontController() {
	}
	public static FrontController getInstance() {
		return instance;
	}
	
	private ChallengeController controller = ChallengeController.getInstance(); //controller 호출
	private ChallengeView view = ChallengeView.getInstance();//View 호출
	private Scanner scanner = new Scanner(System.in); //Scanner 생성을 여기서 함. 
	public void process() {
		view.getChallenge();
		while (true) {
			int menu = view.
		}
		
	}
	
//	private ChallengeView view = new ChallengeView();
//	private ChallengeController controller = ChallengeController.getInstance();
//	ChallengeVO book = controller.getChallenge("0003");

	
	
//	view.getChallenge(book);
}
