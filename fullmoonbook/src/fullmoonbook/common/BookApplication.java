package fullmoonbook.common;

import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.join.MemberVO;

public class BookApplication {
	private static MemberVO session = new MemberVO();
	private static ChallengeVO session1 = new ChallengeVO();

	public static void main(String[] args) throws Exception {
		new FrontController().process();
	}

	public static MemberVO getSession() {
		return session;
	}

	public static ChallengeVO challengeGetSession() {
		return session1;
	}

}
