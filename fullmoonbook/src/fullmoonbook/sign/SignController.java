package fullmoonbook.sign;

import java.util.Scanner;

import fullmoonbook.common.BookstoreApplication;
import fullmoonbook.common.HomeMenu;
import fullmoonbook.join.MemberVO;

public class SignController {
    private static SignController instance = new SignController();
    public static SignController getInstance() {
        return instance;
    }
    private SignController() {}

    private SignService service = SignService.getInstance();
    private SignView view = SignView.getInstance();
    private MemberVO session = BookstoreApplication.getSession();

    public HomeMenu signIn(Scanner scanner) throws Exception {
    	MemberVO vo = view.inputLoginInfo(scanner);
    	MemberVO member = service.findUser(vo);
        if (member != null) {
            session.setId(member.getId());
            session.setPw(member.getPw());
        }
        return view.resultLogin(member);
    }
    public HomeMenu signOut() {
        // 세션 초기화
        session.invalidate();
        return HomeMenu.HOME;
        
    }
}
