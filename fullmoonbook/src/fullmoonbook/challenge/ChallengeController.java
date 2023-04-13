package fullmoonbook.challenge;

import java.util.Scanner;

import fullmoonbook.common.BookApplication;
import fullmoonbook.join.MemberVO;

public class ChallengeController {
	private static ChallengeController instance = new ChallengeController();
    private ChallengeVO session = BookApplication.challengeGetSession();

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
			session.setStatus(vo.getStatus());
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