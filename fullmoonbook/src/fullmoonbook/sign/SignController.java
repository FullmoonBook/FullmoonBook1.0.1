package fullmoonbook.sign;

import java.util.Scanner;

import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.common.BookApplication;
import fullmoonbook.common.HomeMenu;
import fullmoonbook.join.MemberVO;

public class SignController {
	private static SignController instance = new SignController();

	public static SignController getInstance() {
		return instance;
	}

	private SignController() {
	}

	private SignService service = SignService.getInstance();
	private SignView view = SignView.getInstance();
	private MemberVO session = BookApplication.getSession();
	private ChallengeVO challSession = BookApplication.challengeGetSession();

	public MemberVO signIn(Scanner scanner) throws Exception {
		MemberVO vo = view.inputLoginInfo(scanner);
		MemberVO member = service.findUser(vo);
		if (member != null) {
			session.setId(member.getId());
			session.setPw(member.getPw());
			challSession.setId(member.getId());
			return view.resultLogin(member);
		} else {
			return view.resultLogin(null);
		}
	}

	public HomeMenu signOut() {
		// 세션 초기화
		session.invalidate();
		return HomeMenu.HOME;

	}
}
