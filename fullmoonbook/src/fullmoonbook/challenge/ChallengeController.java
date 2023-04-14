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

	public int insertChallengeStatus(ChallengeVO vo) throws Exception {
		ChallengeView insertStatus = ChallengeView.getInstance();
//		ChallengeVO vo1 = challengeView.insertChallengeStatus(scanner);
		if (insertStatus != null) {
			session.setStatus(vo.getStatus());
		}
		return service.insertChallengeStatus(vo);
	}

	public int updateGoal(ChallengeVO vo) throws Exception {
		ChallengeView nowPage = ChallengeView.getInstance();
		if (nowPage != null) {
			session.setNowPage(vo.getNowPage());
		}
		return service.updateGoal(vo);
	}
	public String getStatus(ChallengeVO vo) throws Exception {
		return service.getStatus(vo);
	}
	public int getGoal(ChallengeVO vo) throws Exception {
		return service.getGoal(vo);
		
	}

}
