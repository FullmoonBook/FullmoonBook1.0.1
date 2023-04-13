package fullmoonbook.challenge;

import java.util.Scanner;

import fullmoonbook.common.BookApplication;
import fullmoonbook.join.MemberVO;

public class ChallengeController {
	private static ChallengeController instance = new ChallengeController();
    private ChallengeVO session1 = BookApplication.challengeGetSession();

	private ChallengeController() {
	}
	public static ChallengeController getInstance() {
		return instance;
	}
	
	private ChallengeService service = ChallengeService.getInstance();
	
	public ChallengeVO getChallenge(String searchBookNo) throws Exception {
		return service.getChallenge(searchBookNo);		
	} 
	public ChallengeVO insertChallengeStatus(Scanner scanner) throws Exception {
		ChallengeVO vo = ChallengeView.insertChallengeStatus(scanner);
		if (vo!= null) {
			session1.setStatus(vo.getStatus());
			System.out.println(vo.getStatus());

		//	session.setGoal(0);

		} else {
			System.out.println("challcon 저장 안 됨");
		}
		return service.insertChallengeStatus(vo);	
	}
}

//public MemberVO signIn(Scanner scanner) throws Exception {
//	MemberVO vo = view.inputLoginInfo(scanner);
//	MemberVO member = service.findUser(vo);
//    if (member != null) {
//        session.setId(member.getId());
//        session.setPw(member.getPw());
//    }
//    return view.resultLogin(member);