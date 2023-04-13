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

	public int insertChallengeStatus(ChallengeVO vo) throws Exception {
		ChallengeView insertStatus = ChallengeView.getInstance();
//		ChallengeVO vo1 = challengeView.insertChallengeStatus(scanner);
		if (insertStatus != null) {
			session1.setStatus(vo.getStatus());

		} else {
			System.out.println("challcon 저장 안 됨");
		}
		return service.insertChallengeStatus(vo);
	}

	public int updateGoal(ChallengeVO uGoal) throws Exception {
		ChallengeView nowPage = ChallengeView.getInstance();
		if (nowPage != null) {
			session1.setGoal(uGoal.getGoal());
		}
		return service.updateGoal(uGoal);
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